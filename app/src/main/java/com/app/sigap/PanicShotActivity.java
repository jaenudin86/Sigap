<<<<<<< HEAD

=======
>>>>>>> origin/master
package com.app.sigap;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
<<<<<<< HEAD
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
=======
>>>>>>> origin/master
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
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
<<<<<<< HEAD
=======
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

>>>>>>> origin/master
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

        setMessage(message);
        /**
         * Prepared post image
         * */
        //Save();
    }

    private void setupVariables(Intent intent) {
        latitude = intent.getDoubleExtra("latitude", 0);
        longitude = intent.getDoubleExtra("longitude", 0);

        //todo: show camera and take the shot
        startCameraActivity();
    }

    private void startCameraActivity() {
        PackageManager packageManager = getPackageManager();
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            File mainDirectory = new File(Environment.getExternalStorageDirectory(), "sigap/tmp");

            if (!mainDirectory.exists()) {
                mainDirectory.mkdirs();
            }

            Calendar calendar = Calendar.getInstance();

            uriFilePath = Uri.fromFile(new File(mainDirectory, "IMG_" + calendar.getTimeInMillis()));

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

                bindImageFromPath(imgTakenPath);
<<<<<<< HEAD
=======

                System.out.println(imgTakenPath);
>>>>>>> origin/master
            }
        }
    }

    private void bindImageFromPath(String path) {
        File imgFile = new File(path);

        if (imgFile.exists()) {
            myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            imgPanicSituation.setImageBitmap(myBitmap);
        }
    }
<<<<<<< HEAD

    private String getStringImage (Bitmap bitmap)
    {
        ByteArrayOutputStream baos;
        baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodeImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodeImage;
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
                                setMessage(response);
                            }
                            else
                            {
                                /**
                                 * Success
                                 * */
                                setMessage("success");
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
                            setMessage(error.getMessage());
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
                params.put(SQLConnection.KEY_IMAGE, getStringImage(myBitmap));
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
        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /**
                         * Blocked
                         * */
                    }
                }
        );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
=======
}
>>>>>>> origin/master
