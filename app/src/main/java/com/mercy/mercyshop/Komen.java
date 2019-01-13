package com.mercy.mercyshop;

/**
 * Created by Mizuka Anamato on 26/08/2018.
 */

public class Komen {
    private String Nama;
    private String komen;


    public Komen() {
    }

    public Komen(String nama, String komen) {
        Nama = nama;
        this.komen = komen;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getKomen() {
        return komen;
    }

    public void setKomen(String komen) {
        this.komen = komen;
    }
}
