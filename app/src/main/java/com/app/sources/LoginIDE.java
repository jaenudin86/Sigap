package com.app.sources;

/**
 * Created by blue on 21/10/16.
 */

public interface LoginIDE
{

    /**
     * User preference
     * */
    Integer password_min_length = 6;
    /**
     * End of User preference
     * */

    /**
     * Message
     * */
    String pesan_forgetpassword_checkdate_failed = "Fasilitas ini hanya dapat digunakan dalam waktu 1 x 24 jam." + "\n" + "Terima kasih." + "\n\n" + "Ttd." + "\n" + MainMenuIDE.developer;

    String pesan_sendsms_forgetpassword = "Terima kasih telah menggunakan layanan ini. Mohon tunggu pesan singkat beberapa saat dari kami.";
    /**
     * End of message
     * */

}
