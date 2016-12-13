package com.app.sigap;

<<<<<<< HEAD
import android.app.ProgressDialog;
=======
>>>>>>> origin/master
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
<<<<<<< HEAD
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
=======
import android.os.Build;
import android.os.Bundle;
>>>>>>> origin/master
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> origin/master
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
<<<<<<< HEAD
import com.app.config.AppController;
import com.app.request.AndroidMultipartEntity;
=======
>>>>>>> origin/master
import com.app.sources.SKCKLog;
import com.app.sources.SKCK_IDE;
import com.app.sources.SQLConnection;
import com.app.sources.SimIDE;

<<<<<<< HEAD
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
=======
import java.io.ByteArrayOutputStream;
>>>>>>> origin/master
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SKCK2Activity extends AppCompatActivity {

    /**
     * UI Reference
     * */
    private Button button_upload_photo, button_submit_identitas, button_back_keluarga, button_next_keluarga, button_back_pendidikan, button_next_pendidikan, button_back_perkarapidana, button_next_perkarapidana, button_selesai;
    private CheckBox check_penggunaan;
    private EditText text_namalengkap, text_kota, text_tahun, text_alamat, text_email, text_nomorktp, text_nomorkk, text_kontak, text_photo, text_kebangsaan;
    private EditText text_namalengkap_si, text_kotakelahiran_si, text_tahun_si;
    private EditText text_namalengkap_bapak, text_kotakelahiran_bapak, text_tahun_bapak, text_alamat_bapak;
    private EditText text_namalengkap_ibu, text_kotakelahiran_ibu, text_tahun_ibu, text_alamat_ibu;
    private EditText text_namalengkap_saudara1, text_kotakelahiran_saudara1, text_tahun_saudara1, text_alamat_saudara1;
    private EditText text_sd_namasekolah, text_sd_kota, text_sd_tahun;
    private EditText text_smp_namasekolah, text_smp_kota, text_smp_tahun;
    private EditText text_sma_namasekolah, text_sma_kota, text_sma_tahun;
    private EditText text_univ_namasekolah, text_univ_kota, text_univ_tahun;
    private EditText text_1_luarnegeri, text_penggunaan;
    private ImageButton btn_close;
<<<<<<< HEAD
    private ImageView img_photo_skck;
=======
    private ImageView img_photo;
>>>>>>> origin/master
    private RadioButton radio_female, radio_male, radio_sudahmenikah, radio_belummenikah;
    private RadioButton radio_1_perkarapidana, radio_0_perkarapidana, radio_1_pelanggaran, radio_0_pelanggaran;
    private RelativeLayout ct_data_skck1, ct_data_skck2, ct_data_skck3, ct_data_skck4, ct_data_skck5;
    private Spinner spinner_polres, spinner_bulan, spinner_tanggal, spinner_agama, spinner_kebangsaan, spinner_pekerjaan;
    private Spinner spinner_bulan_si, spinner_tanggal_si, spinner_agama_si, spinner_kebangsaan_si, spinner_pekerjaan_si;
    private Spinner spinner_bulan_bapak, spinner_tanggal_bapak, spinner_agama_bapak, spinner_kebangsaan_bapak, spinner_pekerjaan_bapak;
    private Spinner spinner_bulan_ibu, spinner_tanggal_ibu, spinner_agama_ibu, spinner_kebangsaan_ibu, spinner_pekerjaan_ibu;
    private Spinner spinner_bulan_saudara1, spinner_tanggal_saudara1, spinner_pekerjaan_saudara1;
    private TabLayout tabs;

    /**
     * Variables
     * */
<<<<<<< HEAD
    int success;
    int PICK_IMAGE_REQUEST = 1;
    private static final String TAG = SKCK2Activity.class.getSimpleName();
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private String KEY_IMAGE = "image";
    String tag_json_obj = "json_obj_req";

    private Uri uriFilePath;
    private String imgTakenPath;

    private ProgressDialog progressDialog;
    private long totalSize = 0;
    private String imageName;
    private Bitmap bitmap;

=======
    Bitmap bitmap;
    int success;
    int PICK_IMAGE_REQUEST = 1;
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    String tag_json_obj = "json_obj_req";

>>>>>>> origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_skck2);

        /**
         * Config
         * */
        LoadPolres();

        LoadBulan();
        LoadAgama();
        LoadKebangsaan();
        LoadPekerjaan();

        SetTabs();
        SetTahunSmartphone();

        LoadBulan_SuamiIstri();
        LoadAgama_SuamiIstri();
        LoadKebangsaan_SuamiIstri();
        LoadPekerjaan_SuamiIstri();

        LoadBulan_Bapak();
        LoadAgama_Bapak();
        LoadKebangsaan_Bapak();
        LoadPekerjaan_Bapak();

        LoadBulan_Ibu();
        LoadAgama_Ibu();
        LoadKebangsaan_Ibu();
        LoadPekerjaan_Ibu();

        LoadBulan_Saudara1();
        LoadPekerjaan_Saudara1();
        /**
         * End of Config
         * */

        /**
         * Event
         * */
        Exit();

        ClickPolres();
        ClickBulan();
        ClickTanggal();
        ClickAgama();
        ClickKebangsaan();
        ClickJenisKelamin();
        ClickStatusPernikahan();
        ClickPekerjaan();
        ClickUploadPhoto();
        ClickNextIdentitas();

        OpenTabs();

        ClickBulan_SuamiIstri();
        ClickTanggal_SuamiIstri();
        ClickAgama_SuamiIstri();
        ClickKebangsaan_SuamiIstri();
        ClickPekerjaan_SuamiIstri();
        ClickBulan_Bapak();
        ClickTanggal_Bapak();
        ClickAgama_Bapak();
        ClickKebangsaan_Bapak();
        ClickPekerjaan_Bapak();
        ClickBulan_Ibu();
        ClickTanggal_Ibu();
        ClickAgama_Ibu();
        ClickKebangsaan_Ibu();
        ClickPekerjaan_Ibu();
        ClickBulan_Saudara1();
        ClickTanggal_Saudara1();
        ClickPekerjaan_Saudara1();
        ClickBackKeluarga();
        ClickNextKeluarga();

        ClickBackPendidikan();
        ClickNextPendidikan();

        ClickPerkaraPidana();
        ClickPelanggaran();
        ClickBackPerkaraPidana();
        ClickNextPerkaraPidana();

        ClickFinish();
        /**
         * End of Event
         * */
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /**
         * Launch pelayanan polres activity
         * */
        Intent intent = new Intent(SKCK2Activity.this, PelayananPolresActivity.class);
        startActivity(intent);

        /**
         * End of this activity
         * */
        finishAffinity();
    }

<<<<<<< HEAD
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (uriFilePath != null) {
            outState.putString("uri_file_path", uriFilePath.toString());
        }

        super.onSaveInstanceState(outState);
    }

=======
>>>>>>> origin/master
    private void ClickAgama ()
    {
        spinner_agama = (Spinner) findViewById(R.id.spinner_agama);
        spinner_agama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickAgama_Bapak ()
    {
        spinner_agama_bapak = (Spinner) findViewById(R.id.spinner_agama_bapak);
        spinner_agama_bapak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickAgama_Ibu ()
    {
        spinner_agama_ibu = (Spinner) findViewById(R.id.spinner_agama_ibu);
        spinner_agama_ibu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickAgama_SuamiIstri ()
    {
        spinner_agama_si = (Spinner) findViewById(R.id.spinner_agama_si);
        spinner_agama_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickBackKeluarga ()
    {
        button_back_keluarga = (Button) findViewById(R.id.button_back_keluarga);
        button_back_keluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ct_data_skck1 = (RelativeLayout) findViewById(R.id.ct_data_skck1);
                ct_data_skck2 = (RelativeLayout) findViewById(R.id.ct_data_skck2);
                ct_data_skck3 = (RelativeLayout) findViewById(R.id.ct_data_skck3);
                ct_data_skck4 = (RelativeLayout) findViewById(R.id.ct_data_skck4);
                ct_data_skck5 = (RelativeLayout) findViewById(R.id.ct_data_skck5);

                /**
                 * Enable tab keluarga
                 * */
                LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
                tabStrip.setEnabled(false);
                for (int i = 0; i < tabStrip.getChildCount(); i++) {
                    tabStrip.getChildAt(i).setClickable(false);
                }
                tabStrip.getChildAt(0).setClickable(true);
                tabStrip.getChildAt(1).setClickable(true);
                tabStrip.getChildAt(2).setClickable(false);
                tabStrip.getChildAt(3).setClickable(false);
                tabStrip.getChildAt(4).setClickable(false);

                /**
                 * Select tab item
                 * */
                tabs.getTabAt(0).select();

                /**
                 * Switch UI
                 * */
                ct_data_skck1.setVisibility(View.VISIBLE);
                ct_data_skck2.setVisibility(View.GONE);
                ct_data_skck3.setVisibility(View.GONE);
                ct_data_skck4.setVisibility(View.GONE);
                ct_data_skck5.setVisibility(View.GONE);
            }
        });
    }

    private void ClickBackPendidikan ()
    {
        button_back_pendidikan = (Button) findViewById(R.id.button_back_pendidikan);
        button_back_pendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ct_data_skck1 = (RelativeLayout) findViewById(R.id.ct_data_skck1);
                ct_data_skck2 = (RelativeLayout) findViewById(R.id.ct_data_skck2);
                ct_data_skck3 = (RelativeLayout) findViewById(R.id.ct_data_skck3);
                ct_data_skck4 = (RelativeLayout) findViewById(R.id.ct_data_skck4);
                ct_data_skck5 = (RelativeLayout) findViewById(R.id.ct_data_skck5);

                /**
                 * Enable tab keluarga
                 * */
                LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
                tabStrip.setEnabled(false);
                for (int i = 0; i < tabStrip.getChildCount(); i++) {
                    tabStrip.getChildAt(i).setClickable(false);
                }
                tabStrip.getChildAt(0).setClickable(true);
                tabStrip.getChildAt(1).setClickable(true);
                tabStrip.getChildAt(2).setClickable(true);
                tabStrip.getChildAt(3).setClickable(false);
                tabStrip.getChildAt(4).setClickable(false);

                /**
                 * Select tab item
                 * */
                tabs.getTabAt(1).select();

                /**
                 * Switch UI
                 * */
                ct_data_skck1.setVisibility(View.GONE);
                ct_data_skck2.setVisibility(View.VISIBLE);
                ct_data_skck3.setVisibility(View.GONE);
                ct_data_skck4.setVisibility(View.GONE);
                ct_data_skck5.setVisibility(View.GONE);
            }
        });
    }

    private void ClickBackPerkaraPidana ()
    {
        button_back_perkarapidana = (Button) findViewById(R.id.button_back_perkarapidana);
        button_back_perkarapidana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ct_data_skck1 = (RelativeLayout) findViewById(R.id.ct_data_skck1);
                ct_data_skck2 = (RelativeLayout) findViewById(R.id.ct_data_skck2);
                ct_data_skck3 = (RelativeLayout) findViewById(R.id.ct_data_skck3);
                ct_data_skck4 = (RelativeLayout) findViewById(R.id.ct_data_skck4);
                ct_data_skck5 = (RelativeLayout) findViewById(R.id.ct_data_skck5);

                /**
                 * Enable tab keluarga
                 * */
                LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
                tabStrip.setEnabled(false);
                for (int i = 0; i < tabStrip.getChildCount(); i++) {
                    tabStrip.getChildAt(i).setClickable(false);
                }
                tabStrip.getChildAt(0).setClickable(true);
                tabStrip.getChildAt(1).setClickable(true);
                tabStrip.getChildAt(2).setClickable(true);
                tabStrip.getChildAt(3).setClickable(false);
                tabStrip.getChildAt(4).setClickable(false);

                /**
                 * Select tab item
                 * */
                tabs.getTabAt(1).select();

                /**
                 * Switch UI
                 * */
                ct_data_skck1.setVisibility(View.GONE);
                ct_data_skck2.setVisibility(View.GONE);
                ct_data_skck3.setVisibility(View.VISIBLE);
                ct_data_skck4.setVisibility(View.GONE);
                ct_data_skck5.setVisibility(View.GONE);
            }
        });
    }

    private void ClickBulan ()
    {
        spinner_bulan = (Spinner) findViewById(R.id.spinner_bulan);
        spinner_bulan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                spinner_tanggal = (Spinner) findViewById(R.id.spinner_tanggal);
                text_tahun = (EditText) findViewById(R.id.text_tahun);

                int index;
                index = position;

                if (index > 0)
                {
                    spinner_tanggal.setEnabled(true);
                    text_tahun.setEnabled(false);
                }
                else
                {
                    spinner_tanggal.setEnabled(false);
                    text_tahun.setEnabled(false);
                }

                String tglMid;

                switch (index)
                {
                    case 1:
                        tglMid = SimIDE.tanggallahir_bulan_01;
                        LoadTanggal(true);
                        break;
                    case 2:
                        tglMid = SimIDE.tanggallahir_bulan_02;
                        LoadTanggal(false);
                        break;
                    case 3:
                        tglMid = SimIDE.tanggallahir_bulan_03;
                        LoadTanggal(true);
                        break;
                    case 4:
                        tglMid = SimIDE.tanggallahir_bulan_04;
                        LoadTanggal(false);
                        break;
                    case 5:
                        tglMid = SimIDE.tanggallahir_bulan_05;
                        LoadTanggal(true);
                        break;
                    case 6:
                        tglMid = SimIDE.tanggallahir_bulan_06;
                        LoadTanggal(false);
                        break;
                    case 7:
                        tglMid = SimIDE.tanggallahir_bulan_07;
                        LoadTanggal(true);
                        break;
                    case 8:
                        tglMid = SimIDE.tanggallahir_bulan_08;
                        LoadTanggal(true);
                        break;
                    case 9:
                        tglMid = SimIDE.tanggallahir_bulan_09;
                        LoadTanggal(false);
                        break;
                    case 10:
                        tglMid = SimIDE.tanggallahir_bulan_10;
                        LoadTanggal(true);
                        break;
                    case 11:
                        tglMid = SimIDE.tanggallahir_bulan_11;
                        LoadTanggal(false);
                        break;
                    case 12:
                        tglMid = SimIDE.tanggallahir_bulan_12;
                        LoadTanggal(true);
                        break;
                    default:
                        tglMid = "";
                        LoadTanggalIfNull();
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglMid(tglMid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickBulan_Bapak ()
    {
        spinner_bulan_bapak = (Spinner) findViewById(R.id.spinner_bulan_bapak);
        spinner_bulan_bapak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                spinner_tanggal_bapak = (Spinner) findViewById(R.id.spinner_tanggal_bapak);
                text_tahun_bapak = (EditText) findViewById(R.id.text_tahun_bapak);

                int index;
                index = position;

                if (index > 0)
                {
                    spinner_tanggal_bapak.setEnabled(true);
                    text_tahun_bapak.setEnabled(false);
                }
                else
                {
                    spinner_tanggal_bapak.setEnabled(false);
                    text_tahun_bapak.setEnabled(false);
                }

                String tglMid;

                switch (index)
                {
                    case 1:
                        tglMid = SimIDE.tanggallahir_bulan_01;
                        LoadTanggal_Bapak(true);
                        break;
                    case 2:
                        tglMid = SimIDE.tanggallahir_bulan_02;
                        LoadTanggal_Bapak(false);
                        break;
                    case 3:
                        tglMid = SimIDE.tanggallahir_bulan_03;
                        LoadTanggal_Bapak(true);
                        break;
                    case 4:
                        tglMid = SimIDE.tanggallahir_bulan_04;
                        LoadTanggal_Bapak(false);
                        break;
                    case 5:
                        tglMid = SimIDE.tanggallahir_bulan_05;
                        LoadTanggal_Bapak(true);
                        break;
                    case 6:
                        tglMid = SimIDE.tanggallahir_bulan_06;
                        LoadTanggal_Bapak(false);
                        break;
                    case 7:
                        tglMid = SimIDE.tanggallahir_bulan_07;
                        LoadTanggal_Bapak(true);
                        break;
                    case 8:
                        tglMid = SimIDE.tanggallahir_bulan_08;
                        LoadTanggal_Bapak(true);
                        break;
                    case 9:
                        tglMid = SimIDE.tanggallahir_bulan_09;
                        LoadTanggal_Bapak(false);
                        break;
                    case 10:
                        tglMid = SimIDE.tanggallahir_bulan_10;
                        LoadTanggal_Bapak(true);
                        break;
                    case 11:
                        tglMid = SimIDE.tanggallahir_bulan_11;
                        LoadTanggal_Bapak(false);
                        break;
                    case 12:
                        tglMid = SimIDE.tanggallahir_bulan_12;
                        LoadTanggal_Bapak(true);
                        break;
                    default:
                        tglMid = "";
                        LoadTanggalIfNull_Bapak();
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglMid_bapak(tglMid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickBulan_Ibu ()
    {
        spinner_bulan_ibu = (Spinner) findViewById(R.id.spinner_bulan_ibu);
        spinner_bulan_ibu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                spinner_tanggal_ibu = (Spinner) findViewById(R.id.spinner_tanggal_ibu);
                text_tahun_ibu = (EditText) findViewById(R.id.text_tahun_ibu);

                int index;
                index = position;

                if (index > 0)
                {
                    spinner_tanggal_ibu.setEnabled(true);
                    text_tahun_ibu.setEnabled(false);
                }
                else
                {
                    spinner_tanggal_ibu.setEnabled(false);
                    text_tahun_ibu.setEnabled(false);
                }

                String tglMid;

                switch (index)
                {
                    case 1:
                        tglMid = SimIDE.tanggallahir_bulan_01;
                        LoadTanggal_Ibu(true);
                        break;
                    case 2:
                        tglMid = SimIDE.tanggallahir_bulan_02;
                        LoadTanggal_Ibu(false);
                        break;
                    case 3:
                        tglMid = SimIDE.tanggallahir_bulan_03;
                        LoadTanggal_Ibu(true);
                        break;
                    case 4:
                        tglMid = SimIDE.tanggallahir_bulan_04;
                        LoadTanggal_Ibu(false);
                        break;
                    case 5:
                        tglMid = SimIDE.tanggallahir_bulan_05;
                        LoadTanggal_Ibu(true);
                        break;
                    case 6:
                        tglMid = SimIDE.tanggallahir_bulan_06;
                        LoadTanggal_Ibu(false);
                        break;
                    case 7:
                        tglMid = SimIDE.tanggallahir_bulan_07;
                        LoadTanggal_Ibu(true);
                        break;
                    case 8:
                        tglMid = SimIDE.tanggallahir_bulan_08;
                        LoadTanggal_Ibu(true);
                        break;
                    case 9:
                        tglMid = SimIDE.tanggallahir_bulan_09;
                        LoadTanggal_Ibu(false);
                        break;
                    case 10:
                        tglMid = SimIDE.tanggallahir_bulan_10;
                        LoadTanggal_Ibu(true);
                        break;
                    case 11:
                        tglMid = SimIDE.tanggallahir_bulan_11;
                        LoadTanggal_Ibu(false);
                        break;
                    case 12:
                        tglMid = SimIDE.tanggallahir_bulan_12;
                        LoadTanggal_Ibu(true);
                        break;
                    default:
                        tglMid = "";
                        LoadTanggalIfNull_Ibu();
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglMid_ibu(tglMid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickBulan_Saudara1 ()
    {
        spinner_bulan_saudara1 = (Spinner) findViewById(R.id.spinner_bulan_saudara1);
        spinner_bulan_saudara1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                spinner_tanggal_saudara1 = (Spinner) findViewById(R.id.spinner_tanggal_saudara1);
                text_tahun_saudara1 = (EditText) findViewById(R.id.text_tahun_saudara1);

                int index;
                index = position;

                if (index > 0)
                {
                    spinner_tanggal_saudara1.setEnabled(true);
                    text_tahun_saudara1.setEnabled(false);
                }
                else
                {
                    spinner_tanggal_saudara1.setEnabled(false);
                    text_tahun_saudara1.setEnabled(false);
                }

                String tglMid;

                switch (index)
                {
                    case 1:
                        tglMid = SimIDE.tanggallahir_bulan_01;
                        LoadTanggal_Saudara1(true);
                        break;
                    case 2:
                        tglMid = SimIDE.tanggallahir_bulan_02;
                        LoadTanggal_Saudara1(false);
                        break;
                    case 3:
                        tglMid = SimIDE.tanggallahir_bulan_03;
                        LoadTanggal_Saudara1(true);
                        break;
                    case 4:
                        tglMid = SimIDE.tanggallahir_bulan_04;
                        LoadTanggal_Saudara1(false);
                        break;
                    case 5:
                        tglMid = SimIDE.tanggallahir_bulan_05;
                        LoadTanggal_Saudara1(true);
                        break;
                    case 6:
                        tglMid = SimIDE.tanggallahir_bulan_06;
                        LoadTanggal_Saudara1(false);
                        break;
                    case 7:
                        tglMid = SimIDE.tanggallahir_bulan_07;
                        LoadTanggal_Saudara1(true);
                        break;
                    case 8:
                        tglMid = SimIDE.tanggallahir_bulan_08;
                        LoadTanggal_Saudara1(true);
                        break;
                    case 9:
                        tglMid = SimIDE.tanggallahir_bulan_09;
                        LoadTanggal_Saudara1(false);
                        break;
                    case 10:
                        tglMid = SimIDE.tanggallahir_bulan_10;
                        LoadTanggal_Saudara1(true);
                        break;
                    case 11:
                        tglMid = SimIDE.tanggallahir_bulan_11;
                        LoadTanggal_Saudara1(false);
                        break;
                    case 12:
                        tglMid = SimIDE.tanggallahir_bulan_12;
                        LoadTanggal_Saudara1(true);
                        break;
                    default:
                        tglMid = "";
                        LoadTanggalIfNull_Saudara1();
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglMid_saudara1(tglMid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickBulan_SuamiIstri ()
    {
        spinner_bulan_si = (Spinner) findViewById(R.id.spinner_bulan_si);
        spinner_bulan_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                spinner_tanggal_si = (Spinner) findViewById(R.id.spinner_tanggal_si);
                text_tahun_si = (EditText) findViewById(R.id.text_tahun_si);

                int index;
                index = position;

                if (index > 0)
                {
                    spinner_tanggal_si.setEnabled(true);
                    text_tahun_si.setEnabled(false);
                }
                else
                {
                    spinner_tanggal_si.setEnabled(false);
                    text_tahun_si.setEnabled(false);
                }

                String tglMid;

                switch (index)
                {
                    case 1:
                        tglMid = SimIDE.tanggallahir_bulan_01;
                        LoadTanggal_SuamiIstri(true);
                        break;
                    case 2:
                        tglMid = SimIDE.tanggallahir_bulan_02;
                        LoadTanggal_SuamiIstri(false);
                        break;
                    case 3:
                        tglMid = SimIDE.tanggallahir_bulan_03;
                        LoadTanggal_SuamiIstri(true);
                        break;
                    case 4:
                        tglMid = SimIDE.tanggallahir_bulan_04;
                        LoadTanggal_SuamiIstri(false);
                        break;
                    case 5:
                        tglMid = SimIDE.tanggallahir_bulan_05;
                        LoadTanggal_SuamiIstri(true);
                        break;
                    case 6:
                        tglMid = SimIDE.tanggallahir_bulan_06;
                        LoadTanggal_SuamiIstri(false);
                        break;
                    case 7:
                        tglMid = SimIDE.tanggallahir_bulan_07;
                        LoadTanggal_SuamiIstri(true);
                        break;
                    case 8:
                        tglMid = SimIDE.tanggallahir_bulan_08;
                        LoadTanggal_SuamiIstri(true);
                        break;
                    case 9:
                        tglMid = SimIDE.tanggallahir_bulan_09;
                        LoadTanggal_SuamiIstri(false);
                        break;
                    case 10:
                        tglMid = SimIDE.tanggallahir_bulan_10;
                        LoadTanggal_SuamiIstri(true);
                        break;
                    case 11:
                        tglMid = SimIDE.tanggallahir_bulan_11;
                        LoadTanggal_SuamiIstri(false);
                        break;
                    case 12:
                        tglMid = SimIDE.tanggallahir_bulan_12;
                        LoadTanggal_SuamiIstri(true);
                        break;
                    default:
                        tglMid = "";
                        LoadTanggalIfNull_SuamiIstri();
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglMid_si(tglMid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickFinish ()
    {
        button_selesai = (Button) findViewById(R.id.button_selesai);
        button_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_penggunaan = (EditText) findViewById(R.id.text_penggunaan);
                check_penggunaan = (CheckBox) findViewById(R.id.check_penggunaan);

                String penggunaan = text_penggunaan.getText().toString();
                String message;

                if (TextUtils.isEmpty(penggunaan))
                {
                    message = "Anda belum mengisikan alasan penggunaan.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_penggunaan.requestFocus();
                }
                else if (check_penggunaan.isChecked() == false)
                {
                    message = "Anda harus menceklis tombol pada layar.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    check_penggunaan.requestFocus();
                }
                else
                {
                    /**
                     * Set variables into memor options
                     * */
                    SKCKLog.setPenggunaan(penggunaan);

                    /**
                     * Data processing
                     * */
<<<<<<< HEAD
                    new UploadFileToServer(SQLConnection.URL_PELAYANAN_POLRES_REG_SKCK).execute();
=======
                    SubmitSKCK();
>>>>>>> origin/master
                }
            }
        });
    }

    private void ClickJenisKelamin ()
    {
        radio_male = (RadioButton) findViewById(R.id.radio_male);
        radio_female = (RadioButton) findViewById(R.id.radio_female);

        radio_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                String kelamin, SiHubunganKeluarga;
                kelamin = SimIDE.jeniskelamin_pria;
                SiHubunganKeluarga = "Istri";

=======
                String kelamin;
                kelamin = SimIDE.jeniskelamin_pria;
>>>>>>> origin/master
                radio_female.setChecked(false);
                radio_male.setChecked(true);

                SKCKLog.setJenisKelamin(kelamin);
<<<<<<< HEAD
                SKCKLog.setSiHubunganKeluarga(SiHubunganKeluarga);
=======
>>>>>>> origin/master
            }
        });
        radio_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                String kelamin, SiHubunganKeluarga;
                kelamin = SimIDE.jeniskelamin_wanita;
                SiHubunganKeluarga = "Suami";

=======
                String kelamin;
                kelamin = SimIDE.jeniskelamin_wanita;
>>>>>>> origin/master
                radio_female.setChecked(true);
                radio_male.setChecked(false);

                SKCKLog.setJenisKelamin(kelamin);
<<<<<<< HEAD
                SKCKLog.setSiHubunganKeluarga(SiHubunganKeluarga);
=======
>>>>>>> origin/master
            }
        });
    }

    private void ClickKebangsaan ()
    {
        spinner_kebangsaan = (Spinner) findViewById(R.id.spinner_kebangsaan);
        spinner_kebangsaan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text_kebangsaan = (EditText) findViewById(R.id.text_kebangsaan);
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                int index;
                index = position;

                if (index == 2)
                {
                    text_kebangsaan.setVisibility(View.VISIBLE);
                    text_kebangsaan.requestFocus();
                }
                else
                {
                    text_kebangsaan.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickKebangsaan_Bapak ()
    {
        spinner_kebangsaan_bapak = (Spinner) findViewById(R.id.spinner_kebangsaan_bapak);
        spinner_kebangsaan_bapak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickKebangsaan_Ibu ()
    {
        spinner_kebangsaan_ibu = (Spinner) findViewById(R.id.spinner_kebangsaan_ibu);
        spinner_kebangsaan_ibu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickKebangsaan_SuamiIstri ()
    {
        spinner_kebangsaan_si = (Spinner) findViewById(R.id.spinner_kebangsaan_si);
        spinner_kebangsaan_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickNextIdentitas ()
    {
        button_submit_identitas = (Button) findViewById(R.id.button_submit_identitas);
        button_submit_identitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_polres = (Spinner) findViewById(R.id.spinner_polres);
                text_namalengkap = (EditText) findViewById(R.id.text_namalengkap);
                text_kota = (EditText) findViewById(R.id.text_kota);
                spinner_bulan = (Spinner) findViewById(R.id.spinner_bulan);
                spinner_tanggal = (Spinner) findViewById(R.id.spinner_tanggal);
                text_tahun = (EditText) findViewById(R.id.text_tahun);
                spinner_agama = (Spinner) findViewById(R.id.spinner_agama);
                spinner_kebangsaan = (Spinner) findViewById(R.id.spinner_kebangsaan);
                radio_male = (RadioButton) findViewById(R.id.radio_male);
                radio_female = (RadioButton) findViewById(R.id.radio_female);
                radio_sudahmenikah = (RadioButton) findViewById(R.id.radio_sudahmenikah);
                radio_belummenikah = (RadioButton) findViewById(R.id.radio_belummenikah);
                spinner_pekerjaan = (Spinner) findViewById(R.id.spinner_pekerjaan);
                text_alamat = (EditText) findViewById(R.id.text_alamat);
                text_email = (EditText) findViewById(R.id.text_email);
                text_nomorktp = (EditText) findViewById(R.id.text_nomorktp);
                text_nomorkk = (EditText) findViewById(R.id.text_nomorkk);
                text_kontak = (EditText) findViewById(R.id.text_kontak);
<<<<<<< HEAD
                img_photo_skck = (ImageView) findViewById(R.id.img_photo_skck);
=======
                img_photo = (ImageView) findViewById(R.id.img_photo);
>>>>>>> origin/master
                text_photo = (EditText) findViewById(R.id.text_photo);
                text_kebangsaan = (EditText) findViewById(R.id.text_kebangsaan);
                ct_data_skck1 = (RelativeLayout) findViewById(R.id.ct_data_skck1);
                ct_data_skck2 = (RelativeLayout) findViewById(R.id.ct_data_skck2);
                ct_data_skck3 = (RelativeLayout) findViewById(R.id.ct_data_skck3);
                ct_data_skck4 = (RelativeLayout) findViewById(R.id.ct_data_skck4);
                ct_data_skck5 = (RelativeLayout) findViewById(R.id.ct_data_skck5);

                int iPolres = spinner_polres.getSelectedItemPosition();
                String namalengkap = text_namalengkap.getText().toString();
                String kota = text_kota.getText().toString();
                int iBulan = spinner_bulan.getSelectedItemPosition();
                String bulan;
                if (iBulan < 10)
                {
                    bulan = "0" + iBulan;
                }
                else
                {
                    bulan = "" + iBulan;
                }
                int iTanggal = spinner_tanggal.getSelectedItemPosition();
                String tanggal;
                if (iTanggal < 10)
                {
                    tanggal = "0" + iTanggal;
                }
                else
                {
                    tanggal = "" + iTanggal;
                }
                String tahun = text_tahun.getText().toString();
                Integer iTahun;
                if (tahun.isEmpty())
                {
                    iTahun = 0;
                }
                else
                {
                    iTahun = Integer.parseInt(tahun);
                }
                String tgllahir = tahun + bulan + tanggal;
                Integer iTglLeftSmartphone = Integer.parseInt(SKCKLog.getTglLeftSmartphone());
                Integer iUsia = iTglLeftSmartphone - iTahun;
                int iAgama = spinner_agama.getSelectedItemPosition();
                String agama;
                if (iAgama == SKCK_IDE.index_default_spinner_int)
                {
                    agama = "";
                }
                else
                {
                    agama = spinner_agama.getSelectedItem().toString();
                }
                int iKebangsaan = spinner_kebangsaan.getSelectedItemPosition();
                String kebangsaan;
                if (iKebangsaan == 2)
                {
                    kebangsaan = text_kebangsaan.getText().toString();
                }
                else
                {
                    kebangsaan = spinner_kebangsaan.getSelectedItem().toString();
                }
                int iPekerjaan = spinner_pekerjaan.getSelectedItemPosition();
                String pekerjaan;
                if (iPekerjaan == SKCK_IDE.index_default_spinner_int)
                {
                    pekerjaan = "";
                }
                else
                {
                    pekerjaan = spinner_pekerjaan.getSelectedItem().toString();
                }
                String alamat = text_alamat.getText().toString();
                String email = text_email.getText().toString();
                String nomorktp = text_nomorktp.getText().toString();
                String nomorkk = text_nomorkk.getText().toString();
                String kontak = text_kontak.getText().toString();
                String urlPhoto = text_photo.getText().toString();

                String message;

                if (iPolres == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih wilayah polres.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(namalengkap))
                {
                    message = "Anda belum mengisi nama lengkap.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_namalengkap.requestFocus();
                }
                else if (TextUtils.isEmpty(kota))
                {
                    message = "Anda belum memilih kab. / kota kelahiran.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kota.requestFocus();
                }
                else if (iBulan == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih bulan.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iTanggal == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih tanggal.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(tahun))
                {
                    message = "Anda belum mengisi tahun.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_tahun.requestFocus();
                }
                else if (iTahun > iTglLeftSmartphone)
                {
                    message = "Mohon masukan tahun lahir dengan benar.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iUsia < SimIDE.usia_minimal)
                {
                    message = "Usia minimal 17 tahun.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iAgama == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih agama.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iKebangsaan == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih kebangsaan.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iKebangsaan == 2 && TextUtils.isEmpty(kebangsaan))
                {
                    message = "Anda belum mengisikan kebangsaan.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kebangsaan.requestFocus();
                }
                else if (radio_male.isChecked() == false && radio_female.isChecked() == false)
                {
                    message = "Anda belum memilih jenis kelamin.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (radio_sudahmenikah.isChecked() == false && radio_belummenikah.isChecked() == false)
                {
                    message = "Anda belum memilih status pernikahan.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iPekerjaan == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih pekerjaan.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(alamat))
                {
                    message = "Anda belum mengisi alamat.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_alamat.requestFocus();
                }
                else if (TextUtils.isEmpty(email))
                {
                    message = "Anda belum mengisi email.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_email.requestFocus();
                }
                else if (!isEmail(email))
                {
                    message = "Mohon masukan email dengan benar.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_email.requestFocus();
                }
                else if (isSpacing(email))
                {
                    message = "Tidak boleh ada spasi pada email.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_email.requestFocus();
                }
                else if (TextUtils.isEmpty(nomorktp))
                {
                    message = "Anda belum mengisi nomor ktp.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_nomorktp.requestFocus();
                }
                else if (!isEqualLength(nomorktp, 16))
                {
                    message = "Nomor KTP harus 16 digit.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_nomorktp.requestFocus();
                }
                else if (TextUtils.isEmpty(nomorkk))
                {
                    message = "Anda belum mengisi nomor kartu keluarga.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_nomorkk.requestFocus();
                }
                else if (!isEqualLength(nomorkk, 16))
                {
                    message = "Nomor Kartu Keluarga harus 16 digit.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_nomorkk.requestFocus();
                }
                else if (TextUtils.isEmpty(kontak))
                {
                    message = "Anda belum mengisi nomor telp. / hp.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kontak.requestFocus();
                }
                else if (!isPhoneNumber(kontak))
                {
                    message = "Mohon masukan format nomor telp. / hp dengan benar.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kontak.requestFocus();
                }
                else if (isLessThenLength(kontak, 11))
                {
                    message = "Panjang nomor telp. / hp tidak sesuai standar.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kontak.requestFocus();
                }
                else if (TextUtils.isEmpty(urlPhoto))
                {
                    message = "Anda belum mengunggah foto..";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else
                {
                    /**
                     * Set variables into memory options
                     * */
                    SKCKLog.setNomorKTP(nomorktp);
                    SKCKLog.setNomorKK(nomorkk);
                    SKCKLog.setNamaLengkap(namalengkap);
                    SKCKLog.setKota(kota);
                    SKCKLog.setTglLahir(tgllahir);
                    SKCKLog.setEmail(email);
                    SKCKLog.setKontak(kontak);
                    SKCKLog.setAlamat(alamat);
                    SKCKLog.setAgama(agama);
                    SKCKLog.setKebangsaan(kebangsaan);
                    SKCKLog.setPekerjaan(pekerjaan);
                    SKCKLog.setImage(urlPhoto);

                    /**
                     * Enable tab keluarga
                     * */
                    LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
                    tabStrip.setEnabled(false);
                    for (int i = 0; i < tabStrip.getChildCount(); i++) {
                        tabStrip.getChildAt(i).setClickable(false);
                    }
                    tabStrip.getChildAt(0).setClickable(true);
                    tabStrip.getChildAt(1).setClickable(true);
                    tabStrip.getChildAt(2).setClickable(false);
                    tabStrip.getChildAt(3).setClickable(false);
                    tabStrip.getChildAt(4).setClickable(false);

                    /**
                     * Select tab item
                     * */
                    tabs.getTabAt(1).select();

                    /**
                     * Switch UI
                     * */
                    ct_data_skck1.setVisibility(View.GONE);
                    ct_data_skck2.setVisibility(View.VISIBLE);
                    ct_data_skck3.setVisibility(View.GONE);
                    ct_data_skck4.setVisibility(View.GONE);
                    ct_data_skck5.setVisibility(View.GONE);
                }
            }
        });
    }

    private void ClickNextKeluarga ()
    {
        button_next_keluarga = (Button) findViewById(R.id.button_next_keluarga);
        button_next_keluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_namalengkap_si = (EditText) findViewById(R.id.text_namalengkap_si);
                text_kotakelahiran_si = (EditText) findViewById(R.id.text_kotakelahiran_si);
                spinner_bulan_si = (Spinner) findViewById(R.id.spinner_bulan_si);
                spinner_tanggal_si = (Spinner) findViewById(R.id.spinner_tanggal_si);
                text_tahun_si = (EditText) findViewById(R.id.text_tahun_si);
                spinner_agama_si = (Spinner) findViewById(R.id.spinner_agama_si);
                spinner_kebangsaan_si = (Spinner) findViewById(R.id.spinner_kebangsaan_si);
                spinner_pekerjaan_si = (Spinner) findViewById(R.id.spinner_pekerjaan_si);

                text_namalengkap_bapak = (EditText) findViewById(R.id.text_namalengkap_bapak);
                text_kotakelahiran_bapak = (EditText) findViewById(R.id.text_kotakelahiran_bapak);
                spinner_bulan_bapak = (Spinner) findViewById(R.id.spinner_bulan_bapak);
                spinner_tanggal_bapak = (Spinner) findViewById(R.id.spinner_tanggal_bapak);
                text_tahun_bapak = (EditText) findViewById(R.id.text_tahun_bapak);
                spinner_agama_bapak = (Spinner) findViewById(R.id.spinner_agama_bapak);
                spinner_kebangsaan_bapak = (Spinner) findViewById(R.id.spinner_kebangsaan_bapak);
                spinner_pekerjaan_bapak = (Spinner) findViewById(R.id.spinner_pekerjaan_bapak);
                text_alamat_bapak = (EditText) findViewById(R.id.text_alamat_bapak);

                text_namalengkap_ibu = (EditText) findViewById(R.id.text_namalengkap_ibu);
                text_kotakelahiran_ibu = (EditText) findViewById(R.id.text_kotakelahiran_ibu);
                spinner_bulan_ibu = (Spinner) findViewById(R.id.spinner_bulan_ibu);
                spinner_tanggal_ibu = (Spinner) findViewById(R.id.spinner_tanggal_ibu);
                text_tahun_ibu = (EditText) findViewById(R.id.text_tahun_ibu);
                spinner_agama_ibu = (Spinner) findViewById(R.id.spinner_agama_ibu);
                spinner_kebangsaan_ibu = (Spinner) findViewById(R.id.spinner_kebangsaan_ibu);
                spinner_pekerjaan_ibu = (Spinner) findViewById(R.id.spinner_pekerjaan_ibu);
                text_alamat_ibu = (EditText) findViewById(R.id.text_alamat_ibu);

                text_namalengkap_saudara1 = (EditText) findViewById(R.id.text_namalengkap_saudara1);
                text_kotakelahiran_saudara1 = (EditText) findViewById(R.id.text_kotakelahiran_saudara1);
                spinner_bulan_saudara1 = (Spinner) findViewById(R.id.spinner_bulan_saudara1);
                spinner_tanggal_saudara1 = (Spinner) findViewById(R.id.spinner_tanggal_saudara1);
                text_tahun_saudara1 = (EditText) findViewById(R.id.text_tahun_saudara1);
                spinner_pekerjaan_saudara1 = (Spinner) findViewById(R.id.spinner_pekerjaan_saudara1);
                text_alamat_saudara1 = (EditText) findViewById(R.id.text_alamat_saudara1);

                ct_data_skck1 = (RelativeLayout) findViewById(R.id.ct_data_skck1);
                ct_data_skck2 = (RelativeLayout) findViewById(R.id.ct_data_skck2);
                ct_data_skck3 = (RelativeLayout) findViewById(R.id.ct_data_skck3);
                ct_data_skck4 = (RelativeLayout) findViewById(R.id.ct_data_skck4);
                ct_data_skck5 = (RelativeLayout) findViewById(R.id.ct_data_skck5);

                String namalengkap_si = text_namalengkap_si.getText().toString();
                String kotakelahiran_si = text_kotakelahiran_si.getText().toString();
                int iBulan_si = spinner_bulan_si.getSelectedItemPosition();
                String bulan_si;
                if (iBulan_si < 10)
                {
                    bulan_si = "0" + iBulan_si;
                }
                else
                {
                    bulan_si = "" + iBulan_si;
                }
                int iTanggal_si = spinner_tanggal_si.getSelectedItemPosition();
                String tanggal_si;
                if (iTanggal_si < 10)
                {
                    tanggal_si = "0" + iTanggal_si;
                }
                else
                {
                    tanggal_si = "" + iTanggal_si;
                }
                String tahun_si = text_tahun_si.getText().toString();
                Integer iTahun_si;
                if (tahun_si.isEmpty() == true)
                {
                    iTahun_si = 0;
                    tahun_si = "0000";
                }
                else
                {
                    iTahun_si = Integer.parseInt(tahun_si);
                    tahun_si = "" + tahun_si;
                }
                String tgllahir_si = tahun_si + bulan_si + tanggal_si;
                int iAgama_si = spinner_agama_si.getSelectedItemPosition();
                String agama_si;
                if (iAgama_si == SKCK_IDE.index_default_spinner_int)
                {
                    agama_si = "";
                }
                else
                {
                    agama_si = spinner_agama_si.getSelectedItem().toString();
                }
                int iKebangsaan_si = spinner_kebangsaan_si.getSelectedItemPosition();
                String kebangsaan_si;
                if (iKebangsaan_si == SKCK_IDE.index_default_spinner_int)
                {
                    kebangsaan_si = "";
                }
                else
                {
                    kebangsaan_si = spinner_kebangsaan_si.getSelectedItem().toString();
                }
                int iPekerjaan_si = spinner_pekerjaan_si.getSelectedItemPosition();
                String pekerjaan_si;
                if (iPekerjaan_si == SKCK_IDE.index_default_spinner_int)
                {
                    pekerjaan_si = "";
                }
                else
                {
                    pekerjaan_si = spinner_pekerjaan_si.getSelectedItem().toString();
                }

                String namalengkap_bapak = text_namalengkap_bapak.getText().toString();
                String kotakelahiran_bapak = text_kotakelahiran_bapak.getText().toString();
                int iBulan_bapak = spinner_bulan_bapak.getSelectedItemPosition();
                String bulan_bapak;
                if (iBulan_bapak < 10)
                {
                    bulan_bapak = "0" + iBulan_bapak;
                }
                else
                {
                    bulan_bapak = "" + iBulan_bapak;
                }
                int iTanggal_bapak = spinner_tanggal_bapak.getSelectedItemPosition();
                String tanggal_bapak;
                if (iTanggal_bapak < 10)
                {
                    tanggal_bapak = "0" + iTanggal_bapak;
                }
                else
                {
                    tanggal_bapak = "" + iTanggal_bapak;
                }
                String tahun_bapak = text_tahun_bapak.getText().toString();
                Integer iTahun_bapak;
                if (tahun_bapak.isEmpty() == true)
                {
                    iTahun_bapak = 0;
                    tahun_bapak = "0000";
                }
                else
                {
                    iTahun_bapak = Integer.parseInt(tahun_bapak);
                    tahun_bapak = "" + tahun_bapak;
                }
                String tgllahir_bapak = tahun_bapak + bulan_bapak + tanggal_bapak;
                int iAgama_bapak = spinner_agama_bapak.getSelectedItemPosition();
                String agama_bapak;
                if (iAgama_bapak == SKCK_IDE.index_default_spinner_int)
                {
                    agama_bapak = "";
                }
                else
                {
                    agama_bapak = spinner_agama_bapak.getSelectedItem().toString();
                }
                int iKebangsaan_bapak = spinner_kebangsaan_bapak.getSelectedItemPosition();
                String kebangsaan_bapak;
                if (iKebangsaan_bapak == SKCK_IDE.index_default_spinner_int)
                {
                    kebangsaan_bapak = "";
                }
                else
                {
                    kebangsaan_bapak = spinner_kebangsaan_bapak.getSelectedItem().toString();
                }
                int iPekerjaan_bapak = spinner_pekerjaan_bapak.getSelectedItemPosition();
                String pekerjaan_bapak;
                if (iPekerjaan_bapak == SKCK_IDE.index_default_spinner_int)
                {
                    pekerjaan_bapak = "";
                }
                else
                {
                    pekerjaan_bapak = spinner_pekerjaan_bapak.getSelectedItem().toString();
                }
                String alamat_bapak = text_alamat_bapak.getText().toString();

                String namalengkap_ibu = text_namalengkap_ibu.getText().toString();
                String kotakelahiran_ibu = text_kotakelahiran_ibu.getText().toString();
                int iBulan_ibu = spinner_bulan_ibu.getSelectedItemPosition();
                String bulan_ibu;
                if (iBulan_ibu < 10)
                {
                    bulan_ibu = "0" + iBulan_ibu;
                }
                else
                {
                    bulan_ibu = "" + iBulan_ibu;
                }
                int iTanggal_ibu = spinner_tanggal_ibu.getSelectedItemPosition();
                String tanggal_ibu;
                if (iTanggal_ibu < 10)
                {
                    tanggal_ibu = "0" + iTanggal_ibu;
                }
                else
                {
                    tanggal_ibu = "" + iTanggal_ibu;
                }
                String tahun_ibu = text_tahun_ibu.getText().toString();
                Integer iTahun_ibu;
                if (tahun_ibu.isEmpty() == true)
                {
                    iTahun_ibu = 0;
                    tahun_ibu = "0000";
                }
                else
                {
                    iTahun_ibu = Integer.parseInt(tahun_ibu);
                    tahun_ibu = "" + tahun_ibu;
                }
                String tgllahir_ibu = tahun_ibu + bulan_ibu + tanggal_ibu;
                int iAgama_ibu = spinner_agama_ibu.getSelectedItemPosition();
                String agama_ibu;
                if (iAgama_ibu == SKCK_IDE.index_default_spinner_int)
                {
                    agama_ibu = "";
                }
                else
                {
                    agama_ibu = spinner_agama_ibu.getSelectedItem().toString();
                }
                int iKebangsaan_ibu = spinner_kebangsaan_ibu.getSelectedItemPosition();
                String kebangsaan_ibu;
                if (iKebangsaan_ibu == SKCK_IDE.index_default_spinner_int)
                {
                    kebangsaan_ibu = "";
                }
                else
                {
                    kebangsaan_ibu = spinner_kebangsaan_ibu.getSelectedItem().toString();
                }
                int iPekerjaan_ibu = spinner_pekerjaan_ibu.getSelectedItemPosition();
                String pekerjaan_ibu;
                if (iPekerjaan_ibu == SKCK_IDE.index_default_spinner_int)
                {
                    pekerjaan_ibu = "";
                }
                else
                {
                    pekerjaan_ibu = spinner_pekerjaan_ibu.getSelectedItem().toString();
                }
                String alamat_ibu = text_alamat_ibu.getText().toString();

                String namalengkap_saudara1 = text_namalengkap_saudara1.getText().toString();
                String kotakelahiran_saudara1 = text_kotakelahiran_saudara1.getText().toString();
                int iBulan_saudara1 = spinner_bulan_saudara1.getSelectedItemPosition();
                String bulan_saudara1;
                if (iBulan_saudara1 < 10)
                {
                    bulan_saudara1 = "0" + iBulan_saudara1;
                }
                else
                {
                    bulan_saudara1 = "" + iBulan_saudara1;
                }
                int iTanggal_saudara1 = spinner_tanggal_saudara1.getSelectedItemPosition();
                String tanggal_saudara1;
                if (iTanggal_saudara1 < 10)
                {
                    tanggal_saudara1 = "0" + iTanggal_saudara1;
                }
                else
                {
                    tanggal_saudara1 = "" + iTanggal_saudara1;
                }
                String tahun_saudara1 = text_tahun_saudara1.getText().toString();
                Integer iTahun_saudara1;
                if (tahun_saudara1.isEmpty() == true)
                {
                    iTahun_saudara1 = 0;
                    tahun_saudara1 = "0000";
                }
                else
                {
                    iTahun_saudara1 = Integer.parseInt(tahun_saudara1);
                    tahun_saudara1 = "" + tahun_saudara1;
                }
                String tgllahir_saudara1 = tahun_saudara1 + bulan_saudara1 + tanggal_saudara1;
                int iPekerjaan_saudara1 = spinner_pekerjaan_saudara1.getSelectedItemPosition();
                String pekerjaan_saudara1;
                if (iPekerjaan_saudara1 == SKCK_IDE.index_default_spinner_int)
                {
                    pekerjaan_saudara1 = "";
                }
                else
                {
                    pekerjaan_saudara1 = spinner_pekerjaan_saudara1.getSelectedItem().toString();
                }
                String alamat_saudara1 = text_alamat_saudara1.getText().toString();

                String message;
                /*
                if (TextUtils.isEmpty(namalengkap_si))
                {
                    message = "Anda belum mengisikan nama lengkap `suami / istri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_namalengkap_si.requestFocus();
                }
                else if (TextUtils.isEmpty(kotakelahiran_si))
                {
                    message = "Anda belum mengisikan kab. / kota kelahitan `suami / istri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kotakelahiran_si.requestFocus();
                }
                else if (iBulan_si == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih bulan lahir `suami / istri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iTanggal_si == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih tanggal lahir `suami / istri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(tahun_si))
                {
                    message = "Anda belum mengisikan tahun lair `suami / istri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_tahun_si.requestFocus();
                }
                else if (iAgama_si == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih agama `suami / istri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iKebangsaan_si == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih kebangsaan `suami / istri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iPekerjaan_si == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih pekerjaan `suami / istri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(namalengkap_bapak))
                {
                    message = "Anda belum mengisikan nama lengkap `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_namalengkap_bapak.requestFocus();
                }
                else if (TextUtils.isEmpty(kotakelahiran_bapak))
                {
                    message = "Anda belum mengisikan kota kelahiran `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kotakelahiran_bapak.requestFocus();
                }
                else if (iBulan_bapak == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih bulan kelahiran `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iTanggal_bapak == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih tanggal kelahiran `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(tahun_bapak))
                {
                    message = "Anda belum mengisikan tahun kelahiran `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_tahun_bapak.requestFocus();
                }
                else if (iAgama_bapak == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih agama `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iKebangsaan_bapak == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih kebangsaan `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iPekerjaan_bapak == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih pekerjaan `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(alamat_bapak))
                {
                    message = "Anda belum mengisikan alamat rumah `bapak`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_alamat_bapak.requestFocus();
                }
                else if (TextUtils.isEmpty(namalengkap_ibu))
                {
                    message = "Anda belum mengisikan nama lengkap `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_namalengkap_ibu.requestFocus();
                }
                else if (TextUtils.isEmpty(kotakelahiran_ibu))
                {
                    message = "Anda belum mengisikan kota kelahiran `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kotakelahiran_ibu.requestFocus();
                }
                else if (iBulan_ibu == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih bulan lahir `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iTanggal_ibu == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih tanggal lahir `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(tahun_ibu))
                {
                    message = "Anda belum mengisikan tahun lahir `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_tahun_ibu.requestFocus();
                }
                else if (iAgama_ibu == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih agama `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iKebangsaan_ibu == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih kebangsaan `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iPekerjaan_ibu == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih pekerjaan `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(alamat_ibu))
                {
                    message = "Anda belum mengisikan alamat rumah `ibu`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_alamat_ibu.requestFocus();
                }
                else if (TextUtils.isEmpty(namalengkap_saudara1))
                {
                    message = "Anda belum mengisikan nama lengkap `saudara sekandung / tiri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_namalengkap_saudara1.requestFocus();
                }
                else if (TextUtils.isEmpty(kotakelahiran_saudara1))
                {
                    message = "Anda belum mengisikan kota kelairan `saudara sekandung / tiri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_kotakelahiran_saudara1.requestFocus();
                }
                else if (iBulan_saudara1 == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih bulan lahir `saudara sekandung / tiri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (iTanggal_saudara1 == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih tanggal lahir `saudara sekandung / tiri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(tahun_saudara1))
                {
                    message = "Anda belum mengisi tahun lahir `saudara sekandung / tiri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_tahun_saudara1.requestFocus();
                }
                else if (iPekerjaan_saudara1 == SKCK_IDE.index_default_spinner_int)
                {
                    message = "Anda belum memilih pekerjaan `saudara sekandung / tiri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(alamat_saudara1))
                {
                    message = "Anda belum mengisi alamat `saudara sekandung / tiri`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_alamat_saudara1.requestFocus();
                }
                else
                {...}
                */
                    /**
                     * Set variables into memory options
                     * */
                    SKCKLog.setSiNamaLengkap(namalengkap_si);
                    SKCKLog.setSiKotaKelahiran(kotakelahiran_si);
                    SKCKLog.setSiTglLahir(tgllahir_si);
                    SKCKLog.setSiAgama(agama_si);
                    SKCKLog.setSiKebangsaan(kebangsaan_si);
                    SKCKLog.setSiPekerjaan(pekerjaan_si);
                    SKCKLog.setBapakNamaLengkap(namalengkap_bapak);
                    SKCKLog.setBapakKotaKelahiran(kotakelahiran_bapak);
                    SKCKLog.setBapakTglLahir(tgllahir_bapak);
                    SKCKLog.setBapakAgama(agama_bapak);
                    SKCKLog.setBapakKebangsaan(kebangsaan_bapak);
                    SKCKLog.setBapakPekerjaan(pekerjaan_bapak);
                    SKCKLog.setBapakAlamat(alamat_bapak);
                    SKCKLog.setIbuNamaLengkap(namalengkap_ibu);
                    SKCKLog.setIbuKotaKelahiran(kotakelahiran_ibu);
                    SKCKLog.setIbuTglLahir(tgllahir_ibu);
                    SKCKLog.setIbuAgama(agama_ibu);
                    SKCKLog.setIbuKebangsaan(kebangsaan_ibu);
                    SKCKLog.setIbuPekerjaan(pekerjaan_ibu);
                    SKCKLog.setIbuAlamat(alamat_ibu);
                    SKCKLog.setSaudaraNamaLengkap(namalengkap_saudara1);
                    SKCKLog.setSaudaraKotaKelahiran(kotakelahiran_saudara1);
                    SKCKLog.setSaudaraTglLahir(tgllahir_saudara1);
                    SKCKLog.setSaudaraPekerjaan(pekerjaan_saudara1);
                    SKCKLog.setSaudaraAlamat(alamat_saudara1);

                    /**
                     * Enable tab pendidikan
                     * */
                    LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
                    tabStrip.setEnabled(false);
                    for (int i = 0; i < tabStrip.getChildCount(); i++) {
                        tabStrip.getChildAt(i).setClickable(false);
                    }
                    tabStrip.getChildAt(0).setClickable(true);
                    tabStrip.getChildAt(1).setClickable(true);
                    tabStrip.getChildAt(2).setClickable(true);
                    tabStrip.getChildAt(3).setClickable(false);
                    tabStrip.getChildAt(4).setClickable(false);

                    /**
                     * Select tab item
                     * */
                    tabs.getTabAt(2).select();

                    /**
                     * Switch UI
                     * */
                    ct_data_skck1.setVisibility(View.GONE);
                    ct_data_skck2.setVisibility(View.GONE);
                    ct_data_skck3.setVisibility(View.VISIBLE);
                    ct_data_skck4.setVisibility(View.GONE);
                    ct_data_skck5.setVisibility(View.GONE);
            }
        });
    }

    private void ClickNextPendidikan ()
    {
        button_next_pendidikan = (Button) findViewById(R.id.button_next_pendidikan);
        button_next_pendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_sd_namasekolah = (EditText) findViewById(R.id.text_sd_namasekolah);
                text_sd_kota = (EditText) findViewById(R.id.text_sd_kota);
                text_sd_tahun = (EditText) findViewById(R.id.text_sd_tahun);
                text_smp_namasekolah = (EditText) findViewById(R.id.text_smp_namasekolah);
                text_smp_kota = (EditText) findViewById(R.id.text_smp_kota);
                text_smp_tahun = (EditText) findViewById(R.id.text_smp_tahun);
                text_sma_namasekolah = (EditText) findViewById(R.id.text_sma_namasekolah);
                text_sma_kota = (EditText) findViewById(R.id.text_sma_kota);
                text_sma_tahun = (EditText) findViewById(R.id.text_sma_tahun);
                text_univ_namasekolah = (EditText) findViewById(R.id.text_univ_namasekolah);
                text_univ_kota = (EditText) findViewById(R.id.text_univ_kota);
                text_univ_tahun = (EditText) findViewById(R.id.text_univ_tahun);
                ct_data_skck1 = (RelativeLayout) findViewById(R.id.ct_data_skck1);
                ct_data_skck2 = (RelativeLayout) findViewById(R.id.ct_data_skck2);
                ct_data_skck3 = (RelativeLayout) findViewById(R.id.ct_data_skck3);
                ct_data_skck4 = (RelativeLayout) findViewById(R.id.ct_data_skck4);
                ct_data_skck5 = (RelativeLayout) findViewById(R.id.ct_data_skck5);

                String sd_namasekolah = text_sd_namasekolah.getText().toString();
                String sd_kota = text_sd_kota.getText().toString();
                String sd_tahun = text_sd_tahun.getText().toString();
                String smp_namasekolah = text_smp_namasekolah.getText().toString();
                String smp_kota = text_smp_kota.getText().toString();
                String smp_tahun = text_smp_tahun.getText().toString();
                String sma_namasekolah = text_sma_namasekolah.getText().toString();
                String sma_kota = text_sma_kota.getText().toString();
                String sma_tahun = text_sma_tahun.getText().toString();
                String univ_namasekolah = text_univ_namasekolah.getText().toString();
                String univ_kota = text_univ_kota.getText().toString();
                String univ_tahun = text_univ_tahun.getText().toString();

                String message;

                /*
                if (TextUtils.isEmpty(sd_namasekolah))
                {
                    message = "Anda belum mengisikan nama sekolah `sd`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_sd_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(sd_kota))
                {
                    message = "Anda belum mengisikan kab. / kota sekolah `sd`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_sd_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(sd_tahun))
                {
                    message = "Anda belum mengisikan tahun sekolah `sd`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_sd_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(smp_namasekolah))
                {
                    message = "Anda belum mengisikan nama sekolah `smp`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_smp_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(smp_kota))
                {
                    message = "Anda belum mengisikan kab. / kota sekolah `smp`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_smp_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(smp_tahun))
                {
                    message = "Anda belum mengisikan tahun sekolah `smp`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_smp_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(sma_namasekolah))
                {
                    message = "Anda belum mengisikan nama sekolah `sma`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_sma_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(sma_kota))
                {
                    message = "Anda belum mengisikan kab. / kota sekolah `sma`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_sma_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(sma_tahun))
                {
                    message = "Anda belum mengisikan tahun sekolah `sma`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_sma_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(univ_namasekolah))
                {
                    message = "Anda belum mengisikan nama `universitas`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_univ_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(univ_kota))
                {
                    message = "Anda belum mengisikan kab. / kota `universitas`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_univ_namasekolah.requestFocus();
                }
                else if (TextUtils.isEmpty(univ_tahun))
                {
                    message = "Anda belum mengisikan tahun `universitas`.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                    text_univ_namasekolah.requestFocus();
                } else {...}
                */
                    /**
                     * Set variables into memory options
                     * */
                    SKCKLog.setSdNamaSekolah(sd_namasekolah);
                    SKCKLog.setSdKota(sd_kota);
                    SKCKLog.setSdTahunLulus(sd_tahun);
                    SKCKLog.setSmpNamaSekolah(smp_namasekolah);
                    SKCKLog.setSmpKota(smp_kota);
                    SKCKLog.setSmpTahunLulus(smp_tahun);
                    SKCKLog.setSmaNamaSekolah(sma_namasekolah);
                    SKCKLog.setSmaKota(sma_kota);
                    SKCKLog.setSmaTahunLulus(sma_tahun);
                    SKCKLog.setUnivNamaSekolah(univ_namasekolah);
                    SKCKLog.setUnivKota(univ_kota);
                    SKCKLog.setUnivTahunLulus(univ_tahun);

                    /**
                     * Enable tab perkara pidana
                     * */
                    LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
                    tabStrip.setEnabled(false);
                    for (int i = 0; i < tabStrip.getChildCount(); i++) {
                        tabStrip.getChildAt(i).setClickable(false);
                    }
                    tabStrip.getChildAt(0).setClickable(true);
                    tabStrip.getChildAt(1).setClickable(true);
                    tabStrip.getChildAt(2).setClickable(true);
                    tabStrip.getChildAt(3).setClickable(true);
                    tabStrip.getChildAt(4).setClickable(false);

                    /**
                     * Select tab item
                     * */
                    tabs.getTabAt(3).select();

                    /**
                     * Switch UI
                     * */
                    ct_data_skck1.setVisibility(View.GONE);
                    ct_data_skck2.setVisibility(View.GONE);
                    ct_data_skck3.setVisibility(View.GONE);
                    ct_data_skck4.setVisibility(View.VISIBLE);
                    ct_data_skck5.setVisibility(View.GONE);
            }
        });
    }

    private void ClickNextPerkaraPidana ()
    {
        button_next_perkarapidana = (Button) findViewById(R.id.button_next_perkarapidana);
        button_next_perkarapidana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio_1_perkarapidana = (RadioButton) findViewById(R.id.radio_1_perkarapidana);
                radio_0_perkarapidana = (RadioButton) findViewById(R.id.radio_0_perkarapidana);
                radio_1_pelanggaran = (RadioButton) findViewById(R.id.radio_1_pelanggaran);
                radio_0_pelanggaran = (RadioButton) findViewById(R.id.radio_0_pelanggaran);
                text_1_luarnegeri = (EditText) findViewById(R.id.text_1_luarnegeri);
                ct_data_skck1 = (RelativeLayout) findViewById(R.id.ct_data_skck1);
                ct_data_skck2 = (RelativeLayout) findViewById(R.id.ct_data_skck2);
                ct_data_skck3 = (RelativeLayout) findViewById(R.id.ct_data_skck3);
                ct_data_skck4 = (RelativeLayout) findViewById(R.id.ct_data_skck4);
                ct_data_skck5 = (RelativeLayout) findViewById(R.id.ct_data_skck5);

                String keluarnegeri, message;
                keluarnegeri = text_1_luarnegeri.getText().toString();

                if (radio_1_perkarapidana.isChecked() == false && radio_0_perkarapidana.isChecked() == false)
                {
                    message = "Anda belum memilih perkara pidana.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else if (radio_1_pelanggaran.isChecked() == false && radio_0_pelanggaran.isChecked() == false)
                {
                    message = "Anda belum memilih pelanggaran.";
                    Toast.makeText(SKCK2Activity.this, message, Toast.LENGTH_LONG).show();
                }
                else
                {
                    /**
                     * Set variables into memory options
                     * */
                    SKCKLog.setKeLuarNegeri(keluarnegeri);

                    /**
                     * Enable tab perkara pidana
                     * */
                    LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
                    tabStrip.setEnabled(false);
                    for (int i = 0; i < tabStrip.getChildCount(); i++) {
                        tabStrip.getChildAt(i).setClickable(false);
                    }
                    tabStrip.getChildAt(0).setClickable(true);
                    tabStrip.getChildAt(1).setClickable(true);
                    tabStrip.getChildAt(2).setClickable(true);
                    tabStrip.getChildAt(3).setClickable(true);
                    tabStrip.getChildAt(4).setClickable(true);

                    /**
                     * Select tab item
                     * */
                    tabs.getTabAt(4).select();

                    /**
                     * Switch UI
                     * */
                    ct_data_skck1.setVisibility(View.GONE);
                    ct_data_skck2.setVisibility(View.GONE);
                    ct_data_skck3.setVisibility(View.GONE);
                    ct_data_skck4.setVisibility(View.GONE);
                    ct_data_skck5.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void ClickPekerjaan ()
    {
        spinner_pekerjaan = (Spinner) findViewById(R.id.spinner_pekerjaan);
        spinner_pekerjaan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickPekerjaan_Bapak ()
    {
        spinner_pekerjaan_bapak = (Spinner) findViewById(R.id.spinner_pekerjaan_bapak);
        spinner_pekerjaan_bapak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickPekerjaan_Ibu ()
    {
        spinner_pekerjaan_ibu = (Spinner) findViewById(R.id.spinner_pekerjaan_ibu);
        spinner_pekerjaan_ibu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickPekerjaan_Saudara1 ()
    {
        spinner_pekerjaan_saudara1 = (Spinner) findViewById(R.id.spinner_pekerjaan_saudara1);
        spinner_pekerjaan_saudara1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickPekerjaan_SuamiIstri ()
    {
        spinner_pekerjaan_si = (Spinner) findViewById(R.id.spinner_pekerjaan_si);
        spinner_pekerjaan_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickPelanggaran ()
    {
        radio_1_pelanggaran = (RadioButton) findViewById(R.id.radio_1_pelanggaran);
        radio_0_pelanggaran = (RadioButton) findViewById(R.id.radio_0_pelanggaran);

        radio_1_pelanggaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio_1_pelanggaran.setChecked(true);
                radio_0_pelanggaran.setChecked(false);

                String pelanggaran;
                pelanggaran = "Pernah";
                SKCKLog.setPelanggaran(pelanggaran);
            }
        });
        radio_0_pelanggaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio_1_pelanggaran.setChecked(false);
                radio_0_pelanggaran.setChecked(true);

                String pelanggaran;
                pelanggaran = "Tidak pernah";
                SKCKLog.setPelanggaran(pelanggaran);
            }
        });
    }

    private void ClickPerkaraPidana ()
    {
        radio_1_perkarapidana = (RadioButton) findViewById(R.id.radio_1_perkarapidana);
        radio_0_perkarapidana = (RadioButton) findViewById(R.id.radio_0_perkarapidana);

        radio_1_perkarapidana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio_1_perkarapidana.setChecked(true);
                radio_0_perkarapidana.setChecked(false);

                String perkarapidana;
                perkarapidana = "Pernah";
                SKCKLog.setPerkaraPidana(perkarapidana);
            }
        });
        radio_0_perkarapidana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio_1_perkarapidana.setChecked(false);
                radio_0_perkarapidana.setChecked(true);

                String perkarapidana;
                perkarapidana = "Tidak pernah";
                SKCKLog.setPerkaraPidana(perkarapidana);
            }
        });
    }

    private void ClickPolres ()
    {
        spinner_polres = (Spinner) findViewById(R.id.spinner_polres);
        spinner_polres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickStatusPernikahan ()
    {
        radio_sudahmenikah = (RadioButton) findViewById(R.id.radio_sudahmenikah);
        radio_belummenikah = (RadioButton) findViewById(R.id.radio_belummenikah);

        radio_sudahmenikah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pernikahan;
                pernikahan = SKCK_IDE.status_sudahmenikah;
                radio_sudahmenikah.setChecked(true);
                radio_belummenikah.setChecked(false);

                SKCKLog.setStatusPernikahan(pernikahan);
            }
        });
        radio_belummenikah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pernikahan;
                pernikahan = SKCK_IDE.status_belummenikah;
                radio_sudahmenikah.setChecked(false);
                radio_belummenikah.setChecked(true);

                SKCKLog.setStatusPernikahan(pernikahan);
            }
        });
    }

    private void ClickTanggal ()
    {
        spinner_tanggal = (Spinner) findViewById(R.id.spinner_tanggal);
        spinner_tanggal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                text_tahun = (EditText) findViewById(R.id.text_tahun);

                int index;
                index = position;

                if (index > 0)
                {
                    text_tahun.setEnabled(true);
                }
                else
                {
                    text_tahun.setEnabled(false);
                }

                /**
                 * Set variable declaration
                 * */
                String tglRight;

                switch (index)
                {
                    case 0:
                        tglRight = "";
                        break;
                    default:
                        if (index >= 1 && index < 10)
                        {
                            tglRight = "0" + index;
                        }
                        else
                        {
                            tglRight = "" + index;
                        }
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglRight(tglRight);

                view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickTanggal_Bapak ()
    {
        spinner_tanggal_bapak = (Spinner) findViewById(R.id.spinner_tanggal_bapak);
        spinner_tanggal_bapak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                text_tahun_bapak = (EditText) findViewById(R.id.text_tahun_bapak);

                int index;
                index = position;

                if (index > 0)
                {
                    text_tahun_bapak.setEnabled(true);
                }
                else
                {
                    text_tahun_bapak.setEnabled(false);
                }

                /**
                 * Set variable declaration
                 * */
                String tglRight;

                switch (index)
                {
                    case 0:
                        tglRight = "";
                        break;
                    default:
                        if (index >= 1 && index < 10)
                        {
                            tglRight = "0" + index;
                        }
                        else
                        {
                            tglRight = "" + index;
                        }
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglRight_bapak(tglRight);

                view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickTanggal_Ibu ()
    {
        spinner_tanggal_ibu = (Spinner) findViewById(R.id.spinner_tanggal_ibu);
        spinner_tanggal_ibu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                text_tahun_ibu = (EditText) findViewById(R.id.text_tahun_ibu);

                int index;
                index = position;

                if (index > 0)
                {
                    text_tahun_ibu.setEnabled(true);
                }
                else
                {
                    text_tahun_ibu.setEnabled(false);
                }

                /**
                 * Set variable declaration
                 * */
                String tglRight;

                switch (index)
                {
                    case 0:
                        tglRight = "";
                        break;
                    default:
                        if (index >= 1 && index < 10)
                        {
                            tglRight = "0" + index;
                        }
                        else
                        {
                            tglRight = "" + index;
                        }
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglRight_ibu(tglRight);

                view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickTanggal_Saudara1 ()
    {
        spinner_tanggal_saudara1 = (Spinner) findViewById(R.id.spinner_tanggal_saudara1);
        spinner_tanggal_saudara1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                text_tahun_saudara1 = (EditText) findViewById(R.id.text_tahun_saudara1);

                int index;
                index = position;

                if (index > 0)
                {
                    text_tahun_saudara1.setEnabled(true);
                }
                else
                {
                    text_tahun_saudara1.setEnabled(false);
                }

                /**
                 * Set variable declaration
                 * */
                String tglRight;

                switch (index)
                {
                    case 0:
                        tglRight = "";
                        break;
                    default:
                        if (index >= 1 && index < 10)
                        {
                            tglRight = "0" + index;
                        }
                        else
                        {
                            tglRight = "" + index;
                        }
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglRight_saudara1(tglRight);

                view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickTanggal_SuamiIstri ()
    {
        spinner_tanggal_si = (Spinner) findViewById(R.id.spinner_tanggal_si);
        spinner_tanggal_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                text_tahun_si = (EditText) findViewById(R.id.text_tahun_si);

                int index;
                index = position;

                if (index > 0)
                {
                    text_tahun_si.setEnabled(true);
                }
                else
                {
                    text_tahun_si.setEnabled(false);
                }

                /**
                 * Set variable declaration
                 * */
                String tglRight;

                switch (index)
                {
                    case 0:
                        tglRight = "";
                        break;
                    default:
                        if (index >= 1 && index < 10)
                        {
                            tglRight = "0" + index;
                        }
                        else
                        {
                            tglRight = "" + index;
                        }
                        break;
                }

                /**
                 * Set variable into memory option
                 * */
                SKCKLog.setTglRight_si(tglRight);

                view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no event
            }
        });
    }

    private void ClickUploadPhoto ()
    {
        button_upload_photo = (Button) findViewById(R.id.button_upload_photo);
        button_upload_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });
    }

    private void Exit ()
    {
        btn_close = (ImageButton) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SKCK2Activity.this, PelayananPolresActivity.class);
                startActivity(intent);
                /**
                 * End of this activity
                 * */
                finishAffinity();
            }
        });
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private boolean isEmail (String email)
    {
        return email.contains("@") || email.contains(".com") || email.contains(".co.id") || email.contains(".id") || email.contains(".org") || email.contains(".go.id") || email.contains(".gov") || email.contains(".net");
    }

    private boolean isEqualLength(String value, int length)
    {
        return value.length() == length;
    }

    private boolean isLessThenLength (String value, int length)
    {
        return value.length() < length;
    }

    private boolean isPhoneNumber (String phone)
    {
        return phone.substring(0, 2).equalsIgnoreCase("08") || phone.substring(0, 2).equalsIgnoreCase("62");
    }

    private boolean isSpacing(String spacing)
    {
        return spacing.contains(" ");
    }

    private void KosongkanImage ()
    {
<<<<<<< HEAD
        img_photo_skck.setImageResource(0);
=======
        img_photo.setImageResource(0);
>>>>>>> origin/master
    }

    private void LoadAgama ()
    {
        spinner_agama = (Spinner) findViewById(R.id.spinner_agama);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_agama, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_agama.setAdapter(adapter);
    }

    private void LoadAgama_Bapak ()
    {
        spinner_agama_bapak = (Spinner) findViewById(R.id.spinner_agama_bapak);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_agama, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_agama_bapak.setAdapter(adapter);
    }

    private void LoadAgama_Ibu ()
    {
        spinner_agama_ibu = (Spinner) findViewById(R.id.spinner_agama_ibu);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_agama, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_agama_ibu.setAdapter(adapter);
    }

    private void LoadAgama_SuamiIstri ()
    {
        spinner_agama_si = (Spinner) findViewById(R.id.spinner_agama_si);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_agama, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_agama_si.setAdapter(adapter);
    }

    private void LoadBulan ()
    {
        spinner_bulan = (Spinner) findViewById(R.id.spinner_bulan);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_bulan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_bulan.setAdapter(adapter);
    }

    private void LoadBulan_Bapak ()
    {
        spinner_bulan_bapak = (Spinner) findViewById(R.id.spinner_bulan_bapak);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_bulan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_bulan_bapak.setAdapter(adapter);
    }

    private void LoadBulan_Ibu ()
    {
        spinner_bulan_ibu = (Spinner) findViewById(R.id.spinner_bulan_ibu);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_bulan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_bulan_ibu.setAdapter(adapter);
    }

    private void LoadBulan_Saudara1 ()
    {
        spinner_bulan_saudara1 = (Spinner) findViewById(R.id.spinner_bulan_saudara1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_bulan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_bulan_saudara1.setAdapter(adapter);
    }

    private void LoadBulan_SuamiIstri ()
    {
        spinner_bulan_si = (Spinner) findViewById(R.id.spinner_bulan_si);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_bulan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_bulan_si.setAdapter(adapter);
    }

    private void LoadKebangsaan ()
    {
        spinner_kebangsaan = (Spinner) findViewById(R.id.spinner_kebangsaan);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_kebangsaan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_kebangsaan.setAdapter(adapter);
    }

    private void LoadKebangsaan_Bapak ()
    {
        spinner_kebangsaan_bapak = (Spinner) findViewById(R.id.spinner_kebangsaan_bapak);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_kebangsaan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_kebangsaan_bapak.setAdapter(adapter);
    }

    private void LoadKebangsaan_Ibu ()
    {
        spinner_kebangsaan_ibu = (Spinner) findViewById(R.id.spinner_kebangsaan_ibu);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_kebangsaan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_kebangsaan_ibu.setAdapter(adapter);
    }

    private void LoadKebangsaan_SuamiIstri ()
    {
        spinner_kebangsaan_si = (Spinner) findViewById(R.id.spinner_kebangsaan_si);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_kebangsaan, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_kebangsaan_si.setAdapter(adapter);
    }

    private void LoadPekerjaan ()
    {
        spinner_pekerjaan = (Spinner) findViewById(R.id.spinner_pekerjaan);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_pekerjaan_list, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_pekerjaan.setAdapter(adapter);
    }

    private void LoadPekerjaan_Bapak ()
    {
        spinner_pekerjaan_bapak = (Spinner) findViewById(R.id.spinner_pekerjaan_bapak);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_pekerjaan_list, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_pekerjaan_bapak.setAdapter(adapter);
    }

    private void LoadPekerjaan_Ibu ()
    {
        spinner_pekerjaan_ibu = (Spinner) findViewById(R.id.spinner_pekerjaan_ibu);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_pekerjaan_list, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_pekerjaan_ibu.setAdapter(adapter);
    }

    private void LoadPekerjaan_Saudara1 ()
    {
        spinner_pekerjaan_saudara1 = (Spinner) findViewById(R.id.spinner_pekerjaan_saudara1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_pekerjaan_list, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_pekerjaan_saudara1.setAdapter(adapter);
    }

    private void LoadPekerjaan_SuamiIstri ()
    {
        spinner_pekerjaan_si = (Spinner) findViewById(R.id.spinner_pekerjaan_si);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_pekerjaan_list, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_pekerjaan_si.setAdapter(adapter);
    }

    private void LoadPolres ()
    {
        spinner_polres = (Spinner) findViewById(R.id.spinner_polres);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_polres_list_null, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_polres.setAdapter(adapter);
    }

    private void LoadTanggal (Boolean confirm)
    {
        spinner_tanggal = (Spinner) findViewById(R.id.spinner_tanggal);

        ArrayAdapter<CharSequence> adapter;
        // Create an ArrayAdapter using the string array and a default spinner layout
        if (confirm == true)
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_ganjil, android.R.layout.simple_spinner_item);
        }
        else
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_genap, android.R.layout.simple_spinner_item);
        }

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_tanggal.setAdapter(adapter);
    }

    private void LoadTanggal_Bapak (Boolean confirm)
    {
        spinner_tanggal_bapak = (Spinner) findViewById(R.id.spinner_tanggal_bapak);

        ArrayAdapter<CharSequence> adapter;
        // Create an ArrayAdapter using the string array and a default spinner layout
        if (confirm == true)
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_ganjil, android.R.layout.simple_spinner_item);
        }
        else
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_genap, android.R.layout.simple_spinner_item);
        }

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_tanggal_bapak.setAdapter(adapter);
    }

    private void LoadTanggal_Ibu (Boolean confirm)
    {
        spinner_tanggal_ibu = (Spinner) findViewById(R.id.spinner_tanggal_ibu);

        ArrayAdapter<CharSequence> adapter;
        // Create an ArrayAdapter using the string array and a default spinner layout
        if (confirm == true)
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_ganjil, android.R.layout.simple_spinner_item);
        }
        else
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_genap, android.R.layout.simple_spinner_item);
        }

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_tanggal_ibu.setAdapter(adapter);
    }

    private void LoadTanggal_Saudara1 (Boolean confirm)
    {
        spinner_tanggal_saudara1 = (Spinner) findViewById(R.id.spinner_tanggal_saudara1);

        ArrayAdapter<CharSequence> adapter;
        // Create an ArrayAdapter using the string array and a default spinner layout
        if (confirm == true)
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_ganjil, android.R.layout.simple_spinner_item);
        }
        else
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_genap, android.R.layout.simple_spinner_item);
        }

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_tanggal_saudara1.setAdapter(adapter);
    }

    private void LoadTanggal_SuamiIstri (Boolean confirm)
    {
        spinner_tanggal_si = (Spinner) findViewById(R.id.spinner_tanggal_si);

        ArrayAdapter<CharSequence> adapter;
        // Create an ArrayAdapter using the string array and a default spinner layout
        if (confirm == true)
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_ganjil, android.R.layout.simple_spinner_item);
        }
        else
        {
            adapter = ArrayAdapter.createFromResource
            (this, R.array.skck_tanggal_genap, android.R.layout.simple_spinner_item);
        }

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_tanggal_si.setAdapter(adapter);
    }

    private void LoadTanggalIfNull ()
    {
        spinner_tanggal = (Spinner) findViewById(R.id.spinner_tanggal);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_tanggal_null, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_tanggal.setAdapter(adapter);
    }

    private void LoadTanggalIfNull_Bapak ()
    {
        spinner_tanggal_bapak = (Spinner) findViewById(R.id.spinner_tanggal_bapak);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_tanggal_null, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_tanggal_bapak.setAdapter(adapter);
    }

    private void LoadTanggalIfNull_Ibu ()
    {
        spinner_tanggal_ibu = (Spinner) findViewById(R.id.spinner_tanggal_ibu);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_tanggal_null, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_tanggal_ibu.setAdapter(adapter);
    }

    private void LoadTanggalIfNull_Saudara1 ()
    {
        spinner_tanggal_saudara1 = (Spinner) findViewById(R.id.spinner_tanggal_saudara1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_tanggal_null, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_tanggal_saudara1.setAdapter(adapter);
    }

    private void LoadTanggalIfNull_SuamiIstri ()
    {
        spinner_tanggal_si = (Spinner) findViewById(R.id.spinner_tanggal_si);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.skck_tanggal_null, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_tanggal_si.setAdapter(adapter);
    }

    @Override
<<<<<<< HEAD
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        img_photo_skck = (ImageView) findViewById(R.id.img_photo_skck);
=======
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        img_photo = (ImageView) findViewById(R.id.img_photo);
>>>>>>> origin/master
        text_photo = (EditText) findViewById(R.id.text_photo);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
<<<<<<< HEAD
                //mengambil fambar dari Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                text_photo.setText(filePath.toString());
                System.out.println(text_photo.getText().toString());
                SKCKLog.setImage(text_photo.getText().toString());

                //menampilkan gambar yang dipilih dari gallery ke ImageView
                img_photo_skck.setVisibility(View.VISIBLE);
                img_photo_skck.setImageBitmap(bitmap);

                SKCKLog.setImage(getStringImage(bitmap));
=======
                //mengambil gambar dari Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                text_photo.setText(filePath.toString());

                //menampilkan gambar yang dipilih dari gallery ke ImageView
                img_photo.setVisibility(View.VISIBLE);
                img_photo.setImageBitmap(bitmap);

                String urlPhoto = getStringImage(bitmap);
                SKCKLog.setImage(urlPhoto);
>>>>>>> origin/master
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void OpenTabs ()
    {
        tabs = (TabLayout) findViewById(R.id.tabs);
        ct_data_skck1 = (RelativeLayout) findViewById(R.id.ct_data_skck1);
        ct_data_skck2 = (RelativeLayout) findViewById(R.id.ct_data_skck2);
        ct_data_skck3 = (RelativeLayout) findViewById(R.id.ct_data_skck3);
        ct_data_skck4 = (RelativeLayout) findViewById(R.id.ct_data_skck4);
        ct_data_skck5 = (RelativeLayout) findViewById(R.id.ct_data_skck5);

        //noinspection deprecation
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                int index;
                index = tab.getPosition();

                switch (index)
                {
                    case 1:
                        ct_data_skck1.setVisibility(View.GONE);
                        ct_data_skck2.setVisibility(View.VISIBLE);
                        ct_data_skck3.setVisibility(View.GONE);
                        ct_data_skck4.setVisibility(View.GONE);
                        ct_data_skck5.setVisibility(View.GONE);
                        break;
                    case 2:
                        ct_data_skck1.setVisibility(View.GONE);
                        ct_data_skck2.setVisibility(View.GONE);
                        ct_data_skck3.setVisibility(View.VISIBLE);
                        ct_data_skck4.setVisibility(View.GONE);
                        ct_data_skck5.setVisibility(View.GONE);
                        break;
                    case 3:
                        ct_data_skck1.setVisibility(View.GONE);
                        ct_data_skck2.setVisibility(View.GONE);
                        ct_data_skck3.setVisibility(View.GONE);
                        ct_data_skck4.setVisibility(View.VISIBLE);
                        ct_data_skck5.setVisibility(View.GONE);
                        break;
                    case 4:
                        ct_data_skck1.setVisibility(View.GONE);
                        ct_data_skck2.setVisibility(View.GONE);
                        ct_data_skck3.setVisibility(View.GONE);
                        ct_data_skck4.setVisibility(View.GONE);
                        ct_data_skck5.setVisibility(View.VISIBLE);
                        break;
                    default:
                        ct_data_skck1.setVisibility(View.VISIBLE);
                        ct_data_skck2.setVisibility(View.GONE);
                        ct_data_skck3.setVisibility(View.GONE);
                        ct_data_skck4.setVisibility(View.GONE);
                        ct_data_skck5.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void setMessage(String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(
            "Ok",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    /**
                     * Stay on this activity
                     * */
                    Intent intent = new Intent(SKCK2Activity.this, PelayananPolresActivity.class);
                    finishAffinity();
                }
            }
        );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void setMessageError(String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(
            "Ok",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    /**
                     * Stay on this activity
                     * */
                }
            }
        );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @SuppressWarnings("")
    private void SetTabs ()
    {
        tabs = (TabLayout) findViewById(R.id.tabs);

        LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
        tabStrip.setEnabled(false);
        for(int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setClickable(false);
        }
        tabStrip.getChildAt(0).setClickable(true);
        tabStrip.getChildAt(1).setClickable(false);
        tabStrip.getChildAt(2).setClickable(false);
        tabStrip.getChildAt(3).setClickable(false);
        tabStrip.getChildAt(4).setClickable(false);
    }

    private void SetTahunSmartphone ()
    {
        Date date = Calendar.getInstance().getTime();

        DateFormat format = new SimpleDateFormat("yyyy");

        /**
         * Get year on user smartphone
         * */
        String this_year = format.format(date);

        SKCKLog.setTglLeftSmartphone(this_year);
    }

    private void showFileChooser()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    private void SubmitSKCK ()
    {
        /**
         * Set request method
         * */
        StringRequest stringRequest;
        stringRequest = new StringRequest
            (
                Request.Method.POST,
                SQLConnection.URL_PELAYANAN_POLRES_REG_SKCK,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        /*
                        try {
                            JSONObject jObj = new JSONObject(response);
                            success = jObj.getInt(TAG_SUCCESS);

                            if (success == 1) {
                                Log.d("v Add", jObj.toString());

                                // Toast.makeText(SKCK2Activity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                                setMessage(jObj.getString(TAG_MESSAGE));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        */

                        String message;

                        /**
                         * Jika respon gagal
                         * */
                        if (!response.substring(0, 7).equalsIgnoreCase(SQLConnection.URL_RESPONSE))
                        {
                            message = "" + response;
                            setMessageError(message);
                        }
                        else
                        {
                            message = response.substring(8);
                            setMessage(message);
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
                        error.printStackTrace();

                        String message;
                        message = error.getMessage();
                        setMessageError(message);
                    }
                }
            ){
            protected Map<String, String> getParams()
            {
                /**
                 * Set parameter to send database
                 * */
                Map<String,String> params = new HashMap<String, String>();
                params.put(SQLConnection.KEY_SKCK_NOMORKTP, SKCKLog.getNomorKTP());
                params.put(SQLConnection.KEY_SKCK_NOMORKK, SKCKLog.getNomorKK());
                params.put(SQLConnection.KEY_SKCK_NAMALENGKAP, SKCKLog.getNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_KELAMIN, SKCKLog.getJenisKelamin());
                params.put(SQLConnection.KEY_SKCK_KOTA, SKCKLog.getKota());
                params.put(SQLConnection.KEY_SKCK_TGLLAHIR, SKCKLog.getTglLahir());
                params.put(SQLConnection.KEY_SKCK_AGAMA, SKCKLog.getAgama());
                params.put(SQLConnection.KEY_SKCK_KEBANGSAAN, SKCKLog.getKebangsaan());
                params.put(SQLConnection.KEY_SKCK_PERNIKAHAN, SKCKLog.getStatusPernikahan());
                params.put(SQLConnection.KEY_SKCK_PEKERJAAN, SKCKLog.getPekerjaan());
                params.put(SQLConnection.KEY_SKCK_ALAMAT, SKCKLog.getAlamat());
                params.put(SQLConnection.KEY_SKCK_EMAIL, SKCKLog.getEmail());
                params.put(SQLConnection.KEY_SKCK_KONTAK, SKCKLog.getKontak());
                params.put(SQLConnection.KEY_SKCK_IMAGE, SKCKLog.getImage());

                params.put(SQLConnection.KEY_SKCK_SD_NAMASEKOLAH, SKCKLog.getSdNamaSekolah());
                params.put(SQLConnection.KEY_SKCK_SD_KOTA, SKCKLog.getSdKota());
                params.put(SQLConnection.KEY_SKCK_SD_TAHUNLULUS, SKCKLog.getSdTahunLulus());
                params.put(SQLConnection.KEY_SKCK_SMP_NAMASEKOLAH, SKCKLog.getSmpNamaSekolah());
                params.put(SQLConnection.KEY_SKCK_SMP_KOTA, SKCKLog.getSmpKota());
                params.put(SQLConnection.KEY_SKCK_SMP_TAHUNLULUS, SKCKLog.getSmpTahunLulus());
                params.put(SQLConnection.KEY_SKCK_SMA_NAMASEKOLAH, SKCKLog.getSmaNamaSekolah());
                params.put(SQLConnection.KEY_SKCK_SMA_KOTA, SKCKLog.getSmaKota());
                params.put(SQLConnection.KEY_SKCK_SMA_TAHUNLULUS, SKCKLog.getSmaTahunLulus());
                params.put(SQLConnection.KEY_SKCK_UNIV_NAMASEKOLAH, SKCKLog.getUnivNamaSekolah());
                params.put(SQLConnection.KEY_SKCK_UNIV_KOTA, SKCKLog.getUnivKota());
                params.put(SQLConnection.KEY_SKCK_UNIV_TAHUNLULUS, SKCKLog.getUnivTahunLulus());

                params.put(SQLConnection.KEY_SKCK_PERKARAPIDANA, SKCKLog.getPerkaraPidana());
                params.put(SQLConnection.KEY_SKCK_PELANGGARAN, SKCKLog.getPelanggaran());
                params.put(SQLConnection.KEY_SKCK_KELUARNEGERI, SKCKLog.getKeLuarNegeri());
                params.put(SQLConnection.KEY_SKCK_PENGGUNAAN, SKCKLog.getPenggunaan());

                params.put(SQLConnection.KEY_SKCK_SI_NAMALENGKAP, SKCKLog.getSiNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_SI_HUBUNGANKELUARGA, SKCKLog.getSiHubunganKeluarga());
                params.put(SQLConnection.KEY_SKCK_SI_KOTAKELAHIRAN, SKCKLog.getSiKotaKelahiran());
                params.put(SQLConnection.KEY_SKCK_SI_TGLLAHIR, SKCKLog.getSiTglLahir());
                params.put(SQLConnection.KEY_SKCK_SI_ALAMAT, SKCKLog.getSiAlamat());
                params.put(SQLConnection.KEY_SKCK_SI_AGAMA, SKCKLog.getSiAgama());
                params.put(SQLConnection.KEY_SKCK_SI_KEBANGSAAN, SKCKLog.getSiKebangsaan());
                params.put(SQLConnection.KEY_SKCK_SI_PEKERJAAN, SKCKLog.getSiPekerjaan());

                params.put(SQLConnection.KEY_SKCK_BAPAK_NAMALENGKAP, SKCKLog.getBapakNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_BAPAK_KOTAKELAHIRAN, SKCKLog.getBapakKotaKelahiran());
                params.put(SQLConnection.KEY_SKCK_BAPAK_TGLLAHIR, SKCKLog.getBapakTglLahir());
                params.put(SQLConnection.KEY_SKCK_BAPAK_ALAMAT, SKCKLog.getBapakAlamat());
                params.put(SQLConnection.KEY_SKCK_BAPAK_AGAMA, SKCKLog.getBapakAgama());
                params.put(SQLConnection.KEY_SKCK_BAPAK_KEBANGSAAN, SKCKLog.getBapakKebangsaan());
                params.put(SQLConnection.KEY_SKCK_BAPAK_PEKERJAAN, SKCKLog.getBapakPekerjaan());

                params.put(SQLConnection.KEY_SKCK_IBU_NAMALENGKAP, SKCKLog.getIbuNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_IBU_KOTAKELAHIRAN, SKCKLog.getIbuKotaKelahiran());
                params.put(SQLConnection.KEY_SKCK_IBU_TGLLAHIR, SKCKLog.getIbuTglLahir());
                params.put(SQLConnection.KEY_SKCK_IBU_ALAMAT, SKCKLog.getIbuAlamat());
                params.put(SQLConnection.KEY_SKCK_IBU_AGAMA, SKCKLog.getIbuAgama());
                params.put(SQLConnection.KEY_SKCK_IBU_KEBANGSAAN, SKCKLog.getIbuKebangsaan());
                params.put(SQLConnection.KEY_SKCK_IBU_PEKERJAAN, SKCKLog.getIbuPekerjaan());

                params.put(SQLConnection.KEY_SKCK_SAUDARA_NAMALENGKAP, SKCKLog.getSaudaraNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_KOTAKELAHIRAN, SKCKLog.getSaudaraKotaKelahiran());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_TGLLAHIR, SKCKLog.getSaudaraTglLahir());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_ALAMAT, SKCKLog.getSaudaraAlamat());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_AGAMA, SKCKLog.getSaudaraAgama());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_PEKERJAAN, SKCKLog.getSaudaraPekerjaan());

                return params;
            }
        };

        /**
         * Set volley request
         * */
        // AppController.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

<<<<<<< HEAD
    private void SubmitSKCK2 (){
        //menampilkan progress dialog
        final ProgressDialog loading = ProgressDialog.show(this, "Uploading...", "Please wait...", false, false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, SQLConnection.URL_PELAYANAN_POLRES_REG_SKCK,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Response: " + response.toString());

                        try {
                            JSONObject jObj = new JSONObject(response);
                            success = jObj.getInt(TAG_SUCCESS);

                            if (success == 1) {
                                Log.d("v Add", jObj.toString());

                                setMessage(jObj.getString(TAG_MESSAGE));

                            } else {
                                setMessageError(jObj.getString(TAG_MESSAGE));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //menghilangkan progress dialog
                        loading.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //menghilangkan progress dialog
                        loading.dismiss();

                        //menampilkan toast
                        Toast.makeText(SKCK2Activity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                        Log.d(TAG, error.getMessage().toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams() {
                //membuat parameters
                Map<String,String> params = new HashMap<String, String>();

                //menambah parameter yang di kirim ke web servis
                params.put(SQLConnection.KEY_SKCK_NOMORKTP, SKCKLog.getNomorKTP());
                params.put(SQLConnection.KEY_SKCK_NOMORKK, SKCKLog.getNomorKK());
                params.put(SQLConnection.KEY_SKCK_NAMALENGKAP, SKCKLog.getNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_KELAMIN, SKCKLog.getJenisKelamin());
                params.put(SQLConnection.KEY_SKCK_KOTA, SKCKLog.getKota());
                params.put(SQLConnection.KEY_SKCK_TGLLAHIR, SKCKLog.getTglLahir());
                params.put(SQLConnection.KEY_SKCK_AGAMA, SKCKLog.getAgama());
                params.put(SQLConnection.KEY_SKCK_KEBANGSAAN, SKCKLog.getKebangsaan());
                params.put(SQLConnection.KEY_SKCK_PERNIKAHAN, SKCKLog.getStatusPernikahan());
                params.put(SQLConnection.KEY_SKCK_PEKERJAAN, SKCKLog.getPekerjaan());
                params.put(SQLConnection.KEY_SKCK_ALAMAT, SKCKLog.getAlamat());
                params.put(SQLConnection.KEY_SKCK_EMAIL, SKCKLog.getEmail());
                params.put(SQLConnection.KEY_SKCK_KONTAK, SKCKLog.getKontak());
                // params.put(KEY_IMAGE, getStringImage(bitmap));
                params.put(KEY_IMAGE, SKCKLog.getImage());

                params.put(SQLConnection.KEY_SKCK_SD_NAMASEKOLAH, SKCKLog.getSdNamaSekolah());
                params.put(SQLConnection.KEY_SKCK_SD_KOTA, SKCKLog.getSdKota());
                params.put(SQLConnection.KEY_SKCK_SD_TAHUNLULUS, SKCKLog.getSdTahunLulus());
                params.put(SQLConnection.KEY_SKCK_SMP_NAMASEKOLAH, SKCKLog.getSmpNamaSekolah());
                params.put(SQLConnection.KEY_SKCK_SMP_KOTA, SKCKLog.getSmpKota());
                params.put(SQLConnection.KEY_SKCK_SMP_TAHUNLULUS, SKCKLog.getSmpTahunLulus());
                params.put(SQLConnection.KEY_SKCK_SMA_NAMASEKOLAH, SKCKLog.getSmaNamaSekolah());
                params.put(SQLConnection.KEY_SKCK_SMA_KOTA, SKCKLog.getSmaKota());
                params.put(SQLConnection.KEY_SKCK_SMA_TAHUNLULUS, SKCKLog.getSmaTahunLulus());
                params.put(SQLConnection.KEY_SKCK_UNIV_NAMASEKOLAH, SKCKLog.getUnivNamaSekolah());
                params.put(SQLConnection.KEY_SKCK_UNIV_KOTA, SKCKLog.getUnivKota());
                params.put(SQLConnection.KEY_SKCK_UNIV_TAHUNLULUS, SKCKLog.getUnivTahunLulus());

                params.put(SQLConnection.KEY_SKCK_PERKARAPIDANA, SKCKLog.getPerkaraPidana());
                params.put(SQLConnection.KEY_SKCK_PELANGGARAN, SKCKLog.getPelanggaran());
                params.put(SQLConnection.KEY_SKCK_KELUARNEGERI, SKCKLog.getKeLuarNegeri());
                params.put(SQLConnection.KEY_SKCK_PENGGUNAAN, SKCKLog.getPenggunaan());

                params.put(SQLConnection.KEY_SKCK_SI_NAMALENGKAP, SKCKLog.getSiNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_SI_HUBUNGANKELUARGA, SKCKLog.getSiHubunganKeluarga());
                params.put(SQLConnection.KEY_SKCK_SI_KOTAKELAHIRAN, SKCKLog.getSiKotaKelahiran());
                params.put(SQLConnection.KEY_SKCK_SI_TGLLAHIR, SKCKLog.getSiTglLahir());
                params.put(SQLConnection.KEY_SKCK_SI_ALAMAT, SKCKLog.getSiAlamat());
                params.put(SQLConnection.KEY_SKCK_SI_AGAMA, SKCKLog.getSiAgama());
                params.put(SQLConnection.KEY_SKCK_SI_KEBANGSAAN, SKCKLog.getSiKebangsaan());
                params.put(SQLConnection.KEY_SKCK_SI_PEKERJAAN, SKCKLog.getSiPekerjaan());

                params.put(SQLConnection.KEY_SKCK_BAPAK_NAMALENGKAP, SKCKLog.getBapakNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_BAPAK_KOTAKELAHIRAN, SKCKLog.getBapakKotaKelahiran());
                params.put(SQLConnection.KEY_SKCK_BAPAK_TGLLAHIR, SKCKLog.getBapakTglLahir());
                params.put(SQLConnection.KEY_SKCK_BAPAK_ALAMAT, SKCKLog.getBapakAlamat());
                params.put(SQLConnection.KEY_SKCK_BAPAK_AGAMA, SKCKLog.getBapakAgama());
                params.put(SQLConnection.KEY_SKCK_BAPAK_KEBANGSAAN, SKCKLog.getBapakKebangsaan());
                params.put(SQLConnection.KEY_SKCK_BAPAK_PEKERJAAN, SKCKLog.getBapakPekerjaan());

                params.put(SQLConnection.KEY_SKCK_IBU_NAMALENGKAP, SKCKLog.getIbuNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_IBU_KOTAKELAHIRAN, SKCKLog.getIbuKotaKelahiran());
                params.put(SQLConnection.KEY_SKCK_IBU_TGLLAHIR, SKCKLog.getIbuTglLahir());
                params.put(SQLConnection.KEY_SKCK_IBU_ALAMAT, SKCKLog.getIbuAlamat());
                params.put(SQLConnection.KEY_SKCK_IBU_AGAMA, SKCKLog.getIbuAgama());
                params.put(SQLConnection.KEY_SKCK_IBU_KEBANGSAAN, SKCKLog.getIbuKebangsaan());
                params.put(SQLConnection.KEY_SKCK_IBU_PEKERJAAN, SKCKLog.getIbuPekerjaan());

                params.put(SQLConnection.KEY_SKCK_SAUDARA_NAMALENGKAP, SKCKLog.getSaudaraNamaLengkap());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_KOTAKELAHIRAN, SKCKLog.getSaudaraKotaKelahiran());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_TGLLAHIR, SKCKLog.getSaudaraTglLahir());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_ALAMAT, SKCKLog.getSaudaraAlamat());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_AGAMA, SKCKLog.getSaudaraAgama());
                params.put(SQLConnection.KEY_SKCK_SAUDARA_PEKERJAAN, SKCKLog.getSaudaraPekerjaan());

                //kembali ke parameters
                Log.d(TAG, ""+params);
                return params;
            }
        };

        AppController.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
    }

    private class UploadFileToServer extends AsyncTask<Void, Integer, String> {
        private String url;

        public UploadFileToServer(String url) {
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            // setting progress bar to zero
            progressDialog = new ProgressDialog(SKCK2Activity.this);
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
                imageName = "";
                File sourceFile = new File(Environment.getExternalStorageDirectory()
                        .getAbsolutePath(), imageName);

                String get_image = getStringImage(bitmap);

                // Adding file data to http body
                //entity.addPart("image", new FileBody(sourceFile));
                entity.addPart(SQLConnection.KEY_SKCK_NOMORKTP, new StringBody(SKCKLog.getNomorKTP()));
                entity.addPart(SQLConnection.KEY_SKCK_NOMORKK, new StringBody(SKCKLog.getNomorKK()));
                entity.addPart(SQLConnection.KEY_SKCK_NAMALENGKAP, new StringBody(SKCKLog.getNamaLengkap()));
                entity.addPart(SQLConnection.KEY_SKCK_KELAMIN, new StringBody(SKCKLog.getJenisKelamin()));
                entity.addPart(SQLConnection.KEY_SKCK_KOTA, new StringBody(SKCKLog.getKota()));
                entity.addPart(SQLConnection.KEY_SKCK_TGLLAHIR, new StringBody(SKCKLog.getTglLahir()));
                entity.addPart(SQLConnection.KEY_SKCK_AGAMA, new StringBody(SKCKLog.getAgama()));
                entity.addPart(SQLConnection.KEY_SKCK_KEBANGSAAN, new StringBody(SKCKLog.getKebangsaan()));
                entity.addPart(SQLConnection.KEY_SKCK_PERNIKAHAN, new StringBody(SKCKLog.getStatusPernikahan()));
                entity.addPart(SQLConnection.KEY_SKCK_PEKERJAAN, new StringBody(SKCKLog.getPekerjaan()));
                entity.addPart(SQLConnection.KEY_SKCK_ALAMAT, new StringBody(SKCKLog.getAlamat()));
                entity.addPart(SQLConnection.KEY_SKCK_EMAIL, new StringBody(SKCKLog.getEmail()));
                entity.addPart(SQLConnection.KEY_SKCK_KONTAK, new StringBody(SKCKLog.getKontak()));
                entity.addPart(SQLConnection.KEY_SKCK_IMAGE, new StringBody(get_image));

                entity.addPart(SQLConnection.KEY_SKCK_SD_NAMASEKOLAH, new StringBody(SKCKLog.getSdNamaSekolah()));
                entity.addPart(SQLConnection.KEY_SKCK_SD_KOTA, new StringBody(SKCKLog.getSdKota()));
                entity.addPart(SQLConnection.KEY_SKCK_SD_TAHUNLULUS, new StringBody(SKCKLog.getSdTahunLulus()));
                entity.addPart(SQLConnection.KEY_SKCK_SMP_NAMASEKOLAH, new StringBody(SKCKLog.getSmpNamaSekolah()));
                entity.addPart(SQLConnection.KEY_SKCK_SMP_KOTA, new StringBody(SKCKLog.getSmpKota()));
                entity.addPart(SQLConnection.KEY_SKCK_SMP_TAHUNLULUS, new StringBody(SKCKLog.getSmpTahunLulus()));
                entity.addPart(SQLConnection.KEY_SKCK_SMA_NAMASEKOLAH, new StringBody(SKCKLog.getSmaNamaSekolah()));
                entity.addPart(SQLConnection.KEY_SKCK_SMA_KOTA, new StringBody(SKCKLog.getSmaKota()));
                entity.addPart(SQLConnection.KEY_SKCK_SMA_TAHUNLULUS, new StringBody(SKCKLog.getSmaTahunLulus()));
                entity.addPart(SQLConnection.KEY_SKCK_UNIV_NAMASEKOLAH, new StringBody(SKCKLog.getUnivNamaSekolah()));
                entity.addPart(SQLConnection.KEY_SKCK_UNIV_KOTA, new StringBody(SKCKLog.getUnivKota()));
                entity.addPart(SQLConnection.KEY_SKCK_UNIV_TAHUNLULUS, new StringBody(SKCKLog.getUnivTahunLulus()));

                entity.addPart(SQLConnection.KEY_SKCK_PERKARAPIDANA, new StringBody(SKCKLog.getPerkaraPidana()));
                entity.addPart(SQLConnection.KEY_SKCK_PELANGGARAN, new StringBody(SKCKLog.getPelanggaran()));
                entity.addPart(SQLConnection.KEY_SKCK_KELUARNEGERI, new StringBody(SKCKLog.getKeLuarNegeri()));
                entity.addPart(SQLConnection.KEY_SKCK_PENGGUNAAN, new StringBody(SKCKLog.getPenggunaan()));

                entity.addPart(SQLConnection.KEY_SKCK_SI_NAMALENGKAP, new StringBody(SKCKLog.getSiNamaLengkap()));
                entity.addPart(SQLConnection.KEY_SKCK_SI_HUBUNGANKELUARGA, new StringBody(SKCKLog.getSiHubunganKeluarga()));
                entity.addPart(SQLConnection.KEY_SKCK_SI_KOTAKELAHIRAN, new StringBody(SKCKLog.getSiKotaKelahiran()));
                entity.addPart(SQLConnection.KEY_SKCK_SI_TGLLAHIR, new StringBody(SKCKLog.getSiTglLahir()));
                String SiAlamat = "";
                SKCKLog.setSiAlamat(SiAlamat);
                entity.addPart(SQLConnection.KEY_SKCK_SI_ALAMAT, new StringBody(SKCKLog.getSiAlamat()));
                entity.addPart(SQLConnection.KEY_SKCK_SI_AGAMA, new StringBody(SKCKLog.getSiAgama()));
                entity.addPart(SQLConnection.KEY_SKCK_SI_KEBANGSAAN, new StringBody(SKCKLog.getSiKebangsaan()));
                entity.addPart(SQLConnection.KEY_SKCK_SI_PEKERJAAN, new StringBody(SKCKLog.getSiPekerjaan()));

                entity.addPart(SQLConnection.KEY_SKCK_BAPAK_NAMALENGKAP, new StringBody(SKCKLog.getBapakNamaLengkap()));
                entity.addPart(SQLConnection.KEY_SKCK_BAPAK_KOTAKELAHIRAN, new StringBody(SKCKLog.getBapakKotaKelahiran()));
                entity.addPart(SQLConnection.KEY_SKCK_BAPAK_TGLLAHIR, new StringBody(SKCKLog.getBapakTglLahir()));
                entity.addPart(SQLConnection.KEY_SKCK_BAPAK_ALAMAT, new StringBody(SKCKLog.getBapakAlamat()));
                entity.addPart(SQLConnection.KEY_SKCK_BAPAK_AGAMA, new StringBody(SKCKLog.getBapakAgama()));
                entity.addPart(SQLConnection.KEY_SKCK_BAPAK_KEBANGSAAN, new StringBody(SKCKLog.getBapakKebangsaan()));
                entity.addPart(SQLConnection.KEY_SKCK_BAPAK_PEKERJAAN, new StringBody(SKCKLog.getBapakPekerjaan()));

                entity.addPart(SQLConnection.KEY_SKCK_IBU_NAMALENGKAP, new StringBody(SKCKLog.getIbuNamaLengkap()));
                entity.addPart(SQLConnection.KEY_SKCK_IBU_KOTAKELAHIRAN, new StringBody(SKCKLog.getIbuKotaKelahiran()));
                entity.addPart(SQLConnection.KEY_SKCK_IBU_TGLLAHIR, new StringBody(SKCKLog.getIbuTglLahir()));
                entity.addPart(SQLConnection.KEY_SKCK_IBU_ALAMAT, new StringBody(SKCKLog.getIbuAlamat()));
                entity.addPart(SQLConnection.KEY_SKCK_IBU_AGAMA, new StringBody(SKCKLog.getIbuAgama()));
                entity.addPart(SQLConnection.KEY_SKCK_IBU_KEBANGSAAN, new StringBody(SKCKLog.getIbuKebangsaan()));
                entity.addPart(SQLConnection.KEY_SKCK_IBU_PEKERJAAN, new StringBody(SKCKLog.getIbuPekerjaan()));

                entity.addPart(SQLConnection.KEY_SKCK_SAUDARA_NAMALENGKAP, new StringBody(SKCKLog.getSaudaraNamaLengkap()));
                entity.addPart(SQLConnection.KEY_SKCK_SAUDARA_KOTAKELAHIRAN, new StringBody(SKCKLog.getSaudaraKotaKelahiran()));
                entity.addPart(SQLConnection.KEY_SKCK_SAUDARA_TGLLAHIR, new StringBody(SKCKLog.getSaudaraTglLahir()));
                entity.addPart(SQLConnection.KEY_SKCK_SAUDARA_ALAMAT, new StringBody(SKCKLog.getSaudaraAlamat()));
                String SaudaraAgama = "";
                SKCKLog.setSaudaraAgama(SaudaraAgama);
                entity.addPart(SQLConnection.KEY_SKCK_SAUDARA_AGAMA, new StringBody(SKCKLog.getSaudaraAgama()));
                entity.addPart(SQLConnection.KEY_SKCK_SAUDARA_PEKERJAAN, new StringBody(SKCKLog.getSaudaraPekerjaan()));

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

            String message = "Berhasil";
            setMessage(message);
        }
    }

=======
>>>>>>> origin/master
}
