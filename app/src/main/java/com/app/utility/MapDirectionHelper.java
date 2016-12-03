package com.app.utility;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class MapDirectionHelper {

    public static void showDirection(Context context, String lat, String lon)
    {
        Intent navigation = new Intent(Intent.ACTION_VIEW,  Uri.parse("http://maps.google.com/maps?daddr=" + lat + "," + lon));

        context.startActivity(navigation);
    }

}
