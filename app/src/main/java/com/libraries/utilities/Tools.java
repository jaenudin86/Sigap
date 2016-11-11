package com.libraries.utilities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.config.Config;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/*
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
*/

/*
import app.thecity.ActivityMain;
import app.thecity.ActivitySplash;
import app.thecity.R;
import app.thecity.data.AppConfig;
import app.thecity.data.Constant;
import app.thecity.data.SharedPref;
import app.thecity.model.Place;
*/
public class Tools {

    public static float getAPIVerison() {
        Float f = null;
        try {
            StringBuilder strBuild = new StringBuilder();
            strBuild.append(Build.VERSION.RELEASE.substring(0, 2));
            f = new Float(strBuild.toString());
        } catch (NumberFormatException e) {
            Log.e("", " API" + e.getMessage());
        }

        return f.floatValue();
    }

    private static boolean isLolipopOrHigher() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
    }

    public static void systemBarLolipop(Activity act) {
        if (isLolipopOrHigher()) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //window.setStatusBarColor(Tools.colorDarker(new SharedPref(act).getThemeColorInt()));
        }
    }

    public static GoogleMap configActivityMaps(GoogleMap googleMap) {
        // set map type
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Enable / Disable zooming controls
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        // Enable / Disable Compass icon
        googleMap.getUiSettings().setCompassEnabled(true);
        // Enable / Disable Rotate gesture
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        // Enable / Disable zooming functionality
        googleMap.getUiSettings().setZoomGesturesEnabled(true);

        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);

        return googleMap;
    }

    public static Bitmap createBitmapFromView(Activity act, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }

    public static LatLng getCurLocation(Activity act) {
        if (PermissionUtil.isGroupPermissionGranted(act, Config.PERMISSIONS_LOCATION)) {
            LocationManager manager = (LocationManager) act.getSystemService(Context.LOCATION_SERVICE);
            if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Location loc = getLastKnownLocation(act);
                if (loc != null) {
                    return new LatLng(loc.getLatitude(), loc.getLongitude());
                }
            }
        }
        return null;
    }

    public static Location getLastKnownLocation(Activity act) {
        LocationManager mLocationManager = (LocationManager) act.getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        int permissionCheck = ContextCompat.checkSelfPermission(act, Manifest.permission.ACCESS_FINE_LOCATION );// .checkSelfPermission();

        for (String provider : providers) {
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }

    /*
    public static boolean cekConnection(Context context, View view) {
        ConnectionDetector conn = new ConnectionDetector(context);
        if (conn.isConnectingToInternet()) {
            return true;
        } else {
            noConnectionSnackBar(view);
            return false;
        }
    }

    public static boolean cekConnection(Context context) {
        ConnectionDetector conn = new ConnectionDetector(context);
        if (conn.isConnectingToInternet()) {
            return true;
        } else {
            return false;
        }
    }

    public static void noConnectionSnackBar(View view) {
        Snackbar.make(view, "No internet connection", Snackbar.LENGTH_LONG).show();
    }

    public static void initImageLoader(Context context) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(AppConfig.IMAGE_CACHE)
                .cacheOnDisk(AppConfig.IMAGE_CACHE)
                .imageScaleType(ImageScaleType.EXACTLY)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(options)
                .threadPoolSize(3)
                .memoryCache(new WeakMemoryCache())
                .build();

        ImageLoader.getInstance().init(config);
    }

    public static DisplayImageOptions getGridOption() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(AppConfig.IMAGE_CACHE)
                .cacheOnDisk(AppConfig.IMAGE_CACHE)
                .showImageOnLoading(R.drawable.loading_placeholder) // resource or drawable
                .showImageOnFail(R.drawable.loading_placeholder) // resource or drawable
                .build();

        return options;
    }


    public static String getEmail(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account[] accounts = accountManager.getAccountsByType("com.google");
        if (accounts.length > 0) {
            return accounts[0].name;
        } else {
            return null;
        }
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        } else {
            return manufacturer + " " + model;
        }
    }

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE + "";
    }

    public static int getGridSpanCount(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        float screenWidth = displayMetrics.widthPixels;
        float cellWidth = activity.getResources().getDimension(R.dimen.item_place_width);
        return Math.round(screenWidth / cellWidth);
    }

    public static GoogleMap configStaticMap(Activity act, GoogleMap googleMap, Place place) {
        // set map type
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Enable / Disable zooming controls
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        // Enable / Disable my location button
        googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        // Enable / Disable Compass icon
        googleMap.getUiSettings().setCompassEnabled(false);
        // Enable / Disable Rotate gesture
        googleMap.getUiSettings().setRotateGesturesEnabled(false);
        // Enable / Disable zooming functionality
        googleMap.getUiSettings().setZoomGesturesEnabled(false);
        // enable traffic layer
        googleMap.isTrafficEnabled();
        googleMap.setTrafficEnabled(false);
        googleMap.getUiSettings().setScrollGesturesEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);

        LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View marker_view = inflater.inflate(R.layout.maps_marker, null);
        ((ImageView) marker_view.findViewById(R.id.marker_bg)).setColorFilter(act.getResources().getColor(R.color.marker_secondary));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(place.getPosition()).zoom(12).build();
        MarkerOptions markerOptions = new MarkerOptions().position(place.getPosition());
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(Tools.createBitmapFromView(act, marker_view)));
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        return googleMap;
    }



    public static int getScreenWidth(Context ctx) {
        int columnWidth;
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        final Point point = new Point();
        try {
            display.getSize(point);
        } catch (java.lang.NoSuchMethodError ignore) { // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        columnWidth = point.x;
        return columnWidth;
    }


    public static void rateAction(Activity activity) {
        Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            activity.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())));
        }
    }

    public static void aboutAction(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.dialog_about_title));
        builder.setMessage(activity.getString(R.string.about_text));
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    public static void dialNumber(Context ctx, String phone) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + phone));
        ctx.startActivity(i);
    }

    public static void directUrl(Context ctx, String website) {
        String url = website;
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        ctx.startActivity(i);
    }

    public static void methodShare(Activity act, Place p) {

        // string to share
        String shareBody = "View good place \'" + p.name + "\'"
                + "\n" + "located at : " + p.address + "\n"
                + "Using app \'" + act.getString(R.string.app_name) + "\'";

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");

        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, act.getString(R.string.app_name));
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        act.startActivity(Intent.createChooser(sharingIntent, "Share Using"));
    }



    public static void setActionBarColor(Context ctx, ActionBar actionbar) {
        ColorDrawable colordrw = new ColorDrawable(new SharedPref(ctx).getThemeColorInt());
        actionbar.setBackgroundDrawable(colordrw);
    }

    public static int colorDarker(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f; // value component
        return Color.HSVToColor(hsv);
    }

    public static int colorBrighter(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] /= 0.8f; // value component
        return Color.HSVToColor(hsv);
    }

    public static void restartApplication(Activity activity) {
        activity.finish();
        ActivityMain.getInstance().finish();
        Intent i = new Intent(activity, ActivitySplash.class);
        activity.startActivity(i);
    }

    private static float calculateDistance(LatLng from, LatLng to) {
        Location start = new Location("");
        start.setLatitude(from.latitude);
        start.setLongitude(from.longitude);

        Location end = new Location("");
        end.setLatitude(to.latitude);
        end.setLongitude(to.longitude);

        float distInMeters = start.distanceTo(end);
        float resultDist = 0;
        if(AppConfig.DISTANCE_METRIC_CODE.equals("KILOMETER")){
            resultDist = distInMeters / 1000;
        } else {
            resultDist = (float) (distInMeters * 0.000621371192);
        }
        return resultDist;
    }

    public static List<Place> getSortedDitanceList(List<Place> places, LatLng curLoc) {
        List<Place> result = new ArrayList<>();
        if (places.size() > 0) {
            for (int i = 0; i < places.size(); i++) {
                Place p = places.get(i);
                p.distance = calculateDistance(curLoc, p.getPosition());
                result.add(p);
            }
            Collections.sort(result, new Comparator<Place>() {
                @Override
                public int compare(final Place p1, final Place p2) {
                    return Float.compare(p1.distance, p2.distance);
                }
            });
        } else {
            return places;
        }
        return result;
    }



    public static String getFormatedDistance(float distance) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(1);
        return df.format(distance) + " " + AppConfig.DISTANCE_METRIC_STR;
    }
    // */

}
