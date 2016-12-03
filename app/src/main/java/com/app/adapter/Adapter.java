package com.app.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.sigap.R;
import com.app.sources.Data;
import com.app.sources.MainMenuIDE;
import com.app.utility.MapDirectionHelper;

import java.util.List;

/**
 * Created by blue on 08/11/16.
 */

public class Adapter extends BaseAdapter {

    private Activity activity;
    AlertDialog.Builder dialog;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row_polisi, null);

        Typeface typeface_regular = Typeface.createFromAsset(
            inflater.inflate(R.layout.list_row_polisi, null).getContext().getApplicationContext().getAssets(),
            "fonts/titillium_regular_webfont.ttf"
        );
        Typeface typeface_semibold = Typeface.createFromAsset(
            inflater.inflate(R.layout.list_row_polisi, null).getContext().getApplicationContext().getAssets(),
            "fonts/titillium-semibold-webfont.ttf"
        );

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        final TextView alamat = (TextView) convertView.findViewById(R.id.alamat);
        final TextView telepon = (TextView) convertView.findViewById(R.id.telepon);

        nama.setTypeface(typeface_semibold);
        alamat.setTypeface(typeface_regular);
        telepon.setTypeface(typeface_regular);

        final Data data = items.get(position);

        id.setText(data.getId());
        nama.setText(data.getNama());
        alamat.setText(data.getAlamat());
        telepon.setText(data.getTelepon());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view)
            {
                final CharSequence[] dialogitem = {"Hubungi", "Lihat peta"};
                dialog = new AlertDialog.Builder(activity);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which)
                        {
                            case 0:
                                /**
                                 * Fix varchar contains symbol
                                 * */
                                String phoneNumber;
                                phoneNumber = telepon.getText().toString();
                                phoneNumber = phoneNumber.substring(6);

                                if (phoneNumber.contains("-") || phoneNumber.contains(" "))
                                {
                                    phoneNumber = phoneNumber.replaceAll(" ", "");
                                    phoneNumber = phoneNumber.replaceAll("-", "");
                                }

                                if (phoneNumber.isEmpty() == true)
                                {
                                    setMessage(MainMenuIDE.pesan_phone_empty);
                                }
                                else
                                {
                                    phoneNumber = MainMenuIDE.call + phoneNumber;

                                    /**
                                     * Open intent phone call
                                     * */
                                    Intent phoneCall;
                                    phoneCall = new Intent(Intent.ACTION_CALL);
                                    phoneCall.setData(Uri.parse(phoneNumber));

                                    if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                                    {
                                        return;
                                    }

                                    activity.startActivity(phoneCall);
                                }
                                break;
                            case 1:
                                /**
                                 * Show google maps
                                 * */
                                MapDirectionHelper.showDirection(view.getContext(), data.getLatitude(), data.getLongitude());
                                break;
                        }
                    }
                }).show();
            }
        });

        return convertView;
    }

    private void setMessage(String message)
    {
        AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(activity);
        builder.setMessage(message);
        builder.setPositiveButton(
            "Ok",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    /**
                     * dismiss activity
                     * */
                }
            }
        );

        android.support.v7.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
