package com.app.sigap;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SPHP1Activity extends AppCompatActivity {

    /**
     * UI Component
     * */
    private Button button_search_sp2hp;
    private EditText text_search_sp2hp;
    private ImageButton btn_close;
    private NestedScrollView nsv_1, nsv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_sphp1);

        /**
         * Event
         * */
        ClickExit();
        ClickSearch();
        /**
         * End of Event
         * */
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /**
         * Launch pelayanan polres
         * */
        Intent intent = new Intent(SPHP1Activity.this, PelayananPolresActivity.class);
        startActivity(intent);

        /**
         * End of this activity
         * */
        finishAffinity();
    }

    private void ClickExit ()
    {
        btn_close = (ImageButton) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Launch pelayanan polres
                 * */
                Intent intent = new Intent(SPHP1Activity.this, PelayananPolresActivity.class);
                startActivity(intent);

                /**
                 * End of this activity
                 * */
                finishAffinity();
            }
        });
    }

    private void ClickSearch ()
    {
        button_search_sp2hp = (Button) findViewById(R.id.button_search_sp2hp);
        button_search_sp2hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_search_sp2hp = (EditText) findViewById(R.id.text_search_sp2hp);
                nsv_1 = (NestedScrollView) findViewById(R.id.nsv_1);
                nsv_2 = (NestedScrollView) findViewById(R.id.nsv_2);

                String id = text_search_sp2hp.getText().toString();
                String message;

                if (TextUtils.isEmpty(id))
                {
                    message = "Anda belum mengisikan nomor SP2HP pada kotak pencarian.";
                    setMessage(message);
                    text_search_sp2hp.requestFocus();
                }
                else
                {
                    nsv_1.setVisibility(View.GONE);
                    nsv_2.setVisibility(View.VISIBLE);
                }
            }
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
                }
            }
        );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
