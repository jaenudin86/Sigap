package com.app.sources;

/**
 * Created by blue on 20/11/16.
 */

public class PanikLog {

    private static String Username, Latitude, Longitude, Image, Keterangan;

    public static String getImage() {
        return Image;
    }

    public static void setImage(String image) {
        Image = image;
    }

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String username) {
        Username = username;
    }

    public static String getLatitude() {
        return Latitude;
    }

    public static void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public static String getLongitude() {
        return Longitude;
    }

    public static void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public static String getKeterangan() {
        return Keterangan;
    }

    public static void setKeterangan(String keterangan) {
        Keterangan = keterangan;
    }
}
