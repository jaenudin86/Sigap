package com.app.sigap;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.master.MainMenuActivity;
import com.app.sources.MainMenuIDE;
import com.app.sources.PanikLog;
import com.app.sources.SQLConnection;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PanicShotActivity extends AppCompatActivity {
    private static final int CAMERA_AND_STORAGE_PERMISSION = 1945;
    private static final int REQUEST_CODE = 1946;

    private Button btnSend;
    private ImageButton btn_close;
    private ImageView imgPanicSituation;
    private EditText txtDescription;
    private TextView txt_channel_name;

    private double latitude;
    private double longitude;
    private Bitmap myBitmap;
    private Uri uriFilePath;
    private String imgTakenPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        if (savedInstanceState != null) {
            if (uriFilePath == null && savedInstanceState.getString("uri_file_path") != null) {
                uriFilePath = Uri.parse(savedInstanceState.getString("uri_file_path"));
            }
        }

        setContentView(R.layout.activity_panic_shot);

        if (!isPanicButtonPermissionGranted()) {
            finish();
        }

        Intent intent = getIntent();

        setupUI();
        setupUIListener();
        setupVariables(intent);

        /**
         * Config
         * */
        setFonts();
        /**
         * End of Config
         * */

        /**
         * Listener
         * */
        Exit();
        /**
         * End of Listener
         * */
    }

    private void Exit ()
    {
        btn_close = (ImageButton) findViewById(R.id.btn_close);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * End of panic shot activity
                 * */
                finishAffinity();

                /**
                 * Launch main dashboard activity
                 * */
                Intent intent = new Intent(PanicShotActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isPanicButtonPermissionGranted() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "Please allow a requested permission to upload.", Toast.LENGTH_SHORT).show();

                    ActivityCompat.requestPermissions(this,
                            new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            CAMERA_AND_STORAGE_PERMISSION);
                } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "Please allow a requested permission to upload.", Toast.LENGTH_SHORT).show();

                    ActivityCompat.requestPermissions(this,
                            new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            CAMERA_AND_STORAGE_PERMISSION);
                } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    Toast.makeText(this, "Please allow a requested permission to upload.", Toast.LENGTH_SHORT).show();

                    ActivityCompat.requestPermissions(this,
                            new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            CAMERA_AND_STORAGE_PERMISSION);
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{
                                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.CAMERA},
                            CAMERA_AND_STORAGE_PERMISSION);
                }

                return false;
            }
        }

        return true;
    }

    private void setupUI() {
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
        imgPanicSituation = (ImageView) findViewById(R.id.imgPanicSituation);
    }

    private void setupUIListener() {
        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }

    private void sendRequest() {
        btnSend = (Button) findViewById(R.id.btnSend);
        txtDescription = (EditText) findViewById(R.id.txtDescription);

        String keterangan = txtDescription.getText().toString();
        File file = new File(imgTakenPath);

        /**
         * Get shared preference
         * */
        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences(
            SQLConnection.SHARED_PREFERENCE_ID_LOGIN, Context.MODE_PRIVATE
        );

        String Username;
        Username = sharedPreferences.getString(SQLConnection.SHARED_PREFERENCE_USERNAME, "");

        if (keterangan.isEmpty())
        {
            keterangan = "-";
        }
        else
        {
            keterangan = "" + keterangan;
        }

        /**
         * Set variable
         * */
        PanikLog.setUsername(Username);
        PanikLog.setKeterangan(keterangan);
        PanikLog.setImage(file.getName());

        String VAR_USERNAME = PanikLog.getUsername();
        String VAR_LATITUDE = PanikLog.getLatitude();
        String VAR_LONGITUDE = PanikLog.getLongitude();
        String VAR_KETERANGAN = PanikLog.getKeterangan();
        String VAR_IMAGE = PanikLog.getImage();
        String message =
        "username   : " + VAR_USERNAME + "\n" +
        "latitude   : " + VAR_LATITUDE + "\n" +
        "longitude  : " + VAR_LONGITUDE + "\n" +
        "image      : " + VAR_IMAGE + "\n" +
        "keterangan : " + VAR_KETERANGAN;

        System.out.println(message);

        message = "Foto sedang diupload." + "\n" + "Harap tunggu sampai proses selesai.";
        Toast.makeText(PanicShotActivity.this, message, Toast.LENGTH_LONG).show();

        txtDescription.setVisibility(View.GONE);
        btnSend.setVisibility(View.GONE);
        /**
         * Prepared post image
         * */
        Save();
    }

    private void setupVariables(Intent intent) {
        //latitude = intent.getDoubleExtra("latitude", 0);
        //longitude = intent.getDoubleExtra("longitude", 0);

        latitude = intent.getDoubleExtra(getResources().getString(R.string.latitude), 0);
        longitude = intent.getDoubleExtra(getResources().getString(R.string.longitude), 0);

        String Latitude, Longitude;
        Latitude = "" + latitude;
        Longitude = "" + longitude;

        PanikLog.setLatitude(Latitude);
        PanikLog.setLongitude(Longitude);

        //todo: show camera and take the shot
        startCameraActivity();

        /*
        String message = "Latitude : " + Latitude + "\n" +
                         "Longitude: " + Longitude;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        //
                    }
                }
        );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        */
    }

    private void startCameraActivity() {
        PackageManager packageManager = getPackageManager();

        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Calendar calendar = Calendar.getInstance();

            File file = new File(Environment.getExternalStorageDirectory(), "IMG_" + calendar.getTimeInMillis() + ".jpg");

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                uriFilePath = FileProvider.getUriForFile(this, getPackageName() + ".provider", file);
            } else {
                uriFilePath = Uri.fromFile(file);
            }

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            intent.putExtra(MediaStore.EXTRA_OUTPUT, uriFilePath);

            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (uriFilePath != null) {
            outState.putString("uri_file_path", uriFilePath.toString());
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                // Here is path of your captured image, so you can create bitmap from it, etc.
                imgTakenPath = uriFilePath.getPath();

                Uri selectedImage = uriFilePath;

                getContentResolver().notifyChange(selectedImage, null);
                ContentResolver cr = getContentResolver();
                Bitmap bitmap;

                try {
                    bitmap = android.provider.MediaStore.Images.Media
                            .getBitmap(cr, selectedImage);

                    imgPanicSituation.setImageBitmap(bitmap);
                } catch (Exception e) {
                    Toast.makeText(this, "Try again please.", Toast.LENGTH_SHORT).show();

                    Log.e("Camera", e.toString());
                }

                System.out.println(imgTakenPath);
            }
        }
    }

    private String getStringImage ()
    {
        ContentResolver cr = getContentResolver();
        Bitmap bitmap;

        try {
            bitmap = android.provider.MediaStore.Images.Media
                    .getBitmap(cr, uriFilePath);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

            byte[] imageBytes = baos.toByteArray();

            String encodeImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);

            return encodeImage;
        } catch (Exception e) {
            return "";
        }
    }

    private void Save ()
    {
        /**
         * Set request method
         * */
        StringRequest stringRequest;
        stringRequest = new StringRequest
                (
                    Request.Method.POST,
                    SQLConnection.URL_PANIC,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response)
                        {
                            String message;

                            /**
                             * Jika respon gagal
                             * */
                            if(!response.equalsIgnoreCase(SQLConnection.PANIC_SUCCESS))
                            {
                                //  gagal
                            }
                            else
                            {
                                /**
                                 * Success
                                 * */
                                setMessage();
                            }
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            /**
                             * Tambahkan apa yang terjadi setelah Pesan Error muncul, alternatif
                             * */
                            //setMessage(error.getMessage());
                        }
                    }
                ){
            protected Map<String, String> getParams()
            {
                /**
                 * Set parameter to send database
                 * */
                Map<String,String> params = new HashMap<String, String>();
                params.put(SQLConnection.KEY_USERNAME, PanikLog.getUsername());
                params.put(SQLConnection.KEY_LATITUDE, PanikLog.getLatitude());
                params.put(SQLConnection.KEY_LONGITUDE, PanikLog.getLongitude());
                params.put(SQLConnection.KEY_IMAGE, getStringImage());
                params.put(SQLConnection.KEY_KETERANGAN, PanikLog.getKeterangan());
                return params;
            }
        };

        /**
         * Set volley request
         * */
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @SuppressWarnings("")
    private void setFonts ()
    {
        txt_channel_name = (TextView) findViewById(R.id.txt_channel_name);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
        btnSend = (Button) findViewById(R.id.btnSend);

        /**
         * Set typeface
         * */
        Typeface typeface_regular = Typeface.createFromAsset(
            getApplicationContext().getAssets(),
            "fonts/titillium_regular_webfont.ttf"
        );
        Typeface typeface_semibold = Typeface.createFromAsset(
            getApplicationContext().getAssets(),
            "fonts/titillium_regular_webfont.ttf"
        );

        /**
         * Set custom fonts
         * */
        txt_channel_name.setTypeface(typeface_regular);
        txtDescription.setTypeface(typeface_regular);
        btnSend.setTypeface(typeface_regular);
    }

    private void setMessage()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(MainMenuIDE.pesan_panic_success);
        builder.setPositiveButton(
            "Ok",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    /**
                     * End of panic report activity
                     * */
                    finishAffinity();

                    /**
                     * Launch main dashboard
                     * */
                    Intent intent = new Intent(PanicShotActivity.this, MainMenuActivity.class);
                    startActivity(intent);
                }
            }
        );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void setMessage(final String message)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Save();
                    }
                }
        );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
