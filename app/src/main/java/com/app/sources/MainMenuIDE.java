package com.app.sources;

/**
 * Created by blue on 24/10/16.
 */

public interface MainMenuIDE {

    String call = "tel:";

    String developer = "POLRES Barito Utara";

    String pesan_account_nothing = "Gunakan fasilitas ini hanya dalam keadaan benar-benar lupa kata sandi." + "\n" + "Silahkan buat akun terlebih dahulu." + "\n\n" + "Ttd." + "\n" + developer;

    String pesan_logout = "Keluar aplikasi sekarang ?";

    String pesan_panic_success = "Terima kasih telah mengirimkan bukti kejadian.";

    String pesan_phone_empty = "Maaf anda tidak dapat melakukan panggilan karena nomor telepon tujuan tidak tercantum pada layar." + "\n" + "Terima kasih." + "\n\n" + "Ttd." + "\n" + developer;

    String pesan_signup_finished = "Terima kasih. Silahkan login.";

    String pesan_update_password_failed = "Update password gagal.";

    String pesan_update_password_success = "Update password berhasil." + "\n" + "Silahkan login kembali dengan password baru.";

    String phone_developer = "085221927290";

    String phone_polres_baritoutara = call + "0519" + "21062";

}
