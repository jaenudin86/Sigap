package com.app.sigap;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
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

import com.app.master.MainMenuActivity;
import com.app.request.AndroidMultipartEntity;
import com.app.sources.MainMenuIDE;
import com.app.sources.PanikLog;
import com.app.sources.SQLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

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
    private Uri uriFilePath;
    private String imgTakenPath;

    private ProgressDialog progressDialog;
    private long totalSize = 0;
    private String imageName;
    private Bitmap bitmap;

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /**
         * Finish panic shot activity
         * */
        finishAffinity();

        /**
         * Launch main dashboard
         * */
        Intent intent = new Intent(PanicShotActivity.this, MainMenuActivity.class);
        startActivity(intent);
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
        progressDialog = new ProgressDialog(this);

//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);

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
    }

    private void startCameraActivity() {
        PackageManager packageManager = getPackageManager();

        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Calendar calendar = Calendar.getInstance();

            imageName = "IMG_" + calendar.getTimeInMillis() + ".jpg";
            File file = new File(Environment.getExternalStorageDirectory(), imageName);

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
                //Bitmap bitmap;

                try {
                    bitmap = android.provider.MediaStore.Images.Media
                            .getBitmap(cr, selectedImage);

                    // store the image so we can send this file later to our server
                    MediaStore.Images.Media.insertImage(cr, bitmap, imageName, "panic image");

                    // display bitmap to view
                    imgPanicSituation.setImageBitmap(bitmap);
                } catch (Exception e) {
                    Toast.makeText(this, "Try again please.", Toast.LENGTH_SHORT).show();

                    Log.e("Camera", e.toString());
                }

                System.out.println(imgTakenPath);
            }
        }
    }

    private String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

//    private String getStringImage ()
//    {
//        ContentResolver cr = getContentResolver();
//        Bitmap bitmap;
//
//        try {
//            bitmap = android.provider.MediaStore.Images.Media
//                    .getBitmap(cr, uriFilePath);
//
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//
//            byte[] imageBytes = baos.toByteArray();
//
//            String encodeImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
//
//            return encodeImage;
//        } catch (Exception e) {
//            return "";
//        }
//    }

    private void Save ()
    {
        /**
         * Set request method
         * */
//        StringRequest stringRequest;
//        stringRequest = new StringRequest
//                (
//                    Request.Method.POST,
//                    SQLConnection.URL_PANIC,
//                    new Response.Listener<String>()
//                    {
//                        @Override
//                        public void onResponse(String response)
//                        {
//                            String message;
//
//                            /**
//                             * Jika respon gagal
//                             * */
//                            if(!response.equalsIgnoreCase(SQLConnection.PANIC_SUCCESS))
//                            {
//                                //  gagal
//                            }
//                            else
//                            {
//                                /**
//                                 * Success
//                                 * */
//                                setMessage();
//                            }
//                        }
//                    },
//                    new Response.ErrorListener()
//                    {
//                        @Override
//                        public void onErrorResponse(VolleyError error)
//                        {
//                            /**
//                             * Tambahkan apa yang terjadi setelah Pesan Error muncul, alternatif
//                             * */
//                            //setMessage(error.getMessage());
//                        }
//                    }
//                ){
//            protected Map<String, String> getParams()
//            {
//                /**
//                 * Set parameter to send database
//                 * */
//                Map<String,String> params = new HashMap<String, String>();
//                params.put(SQLConnection.KEY_USERNAME, PanikLog.getUsername());
//                params.put(SQLConnection.KEY_LATITUDE, PanikLog.getLatitude());
//                params.put(SQLConnection.KEY_LONGITUDE, PanikLog.getLongitude());
//                params.put(SQLConnection.KEY_IMAGE, getStringImage());
//                params.put(SQLConnection.KEY_KETERANGAN, PanikLog.getKeterangan());
//                return params;
//            }
//        };

//        MultipartRequest panicRequest = new MultipartRequest(SQLConnection.URL_PANIC,
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                    }
//                }, null, "");
//
//        /**
//         * Set volley request
//         * */
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        requestQueue.add(panicRequest);

        new UploadFileToServer(
                SQLConnection.URL_PANIC,
                PanikLog.getUsername(),
                PanikLog.getLatitude(),
                PanikLog.getLongitude(),
                PanikLog.getKeterangan())
            .execute();
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

    private class UploadFileToServer extends AsyncTask<Void, Integer, String> {
        private String url;
        private final String currentUserName;
        private final String latitude;
        private final String longitude;
        private final String keterangan;

        public UploadFileToServer(String url, String currentUserName,
                                  String latitude, String longitude, String keterangan) {
            this.url = url;
            this.currentUserName = currentUserName;
            this.latitude = latitude;
            this.longitude = longitude;
            this.keterangan = keterangan;
        }

        @Override
        protected void onPreExecute() {
            // setting progress bar to zero
            progressDialog.setProgress(0);

            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            // Making progress bar visible
            progressDialog.show();

            // updating progress bar value
            progressDialog.setProgress(progress[0]);
            progressDialog.setMessage(String.format("Uploading %d", progress[0]));

            Log.d("SigapUploadProgress", String.valueOf(progress[0]) + "%");
        }

        @Override
        protected String doInBackground(Void... params) {
            return uploadFile();
        }

        @SuppressWarnings("deprecation")
        private String uploadFile() {
            String responseString = null;

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);

            try {
                AndroidMultipartEntity entity = new AndroidMultipartEntity(
                        new AndroidMultipartEntity.ProgressListener() {

                            @Override
                            public void transferred(long num) {
                                publishProgress((int) ((num / (float) totalSize) * 100));
                            }
                        });

                // Adding file data to http body
                File sourceFile = new File(Environment.getExternalStorageDirectory()
                        .getAbsolutePath(), imageName);

                String get_image = getStringImage(bitmap);

                // Adding file data to http body
                //entity.addPart("image", new FileBody(sourceFile));
                entity.addPart("image", new StringBody(get_image));
                entity.addPart("username", new StringBody(this.currentUserName));
                entity.addPart("latitude", new StringBody(this.latitude));
                entity.addPart("longitude", new StringBody(this.longitude));
                entity.addPart("keterangan", new StringBody(this.keterangan));

                totalSize = entity.getContentLength();
                httppost.setEntity(entity);

                // Making server call
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity r_entity = response.getEntity();

                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    // Server response
                    responseString = EntityUtils.toString(r_entity);
                } else {
                    responseString = "Error occurred! Http Status Code: " + statusCode;
                }

            } catch (ClientProtocolException e) {
                responseString = e.toString();
            } catch (IOException e) {
                responseString = e.toString();
            }

            return responseString;

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();

            if (!result.equalsIgnoreCase(SQLConnection.PANIC_SUCCESS)) {
                // todo: fill this condition
            } else {
                // todo: fill this condition
            }

            setMessage();
        }
    }
}
