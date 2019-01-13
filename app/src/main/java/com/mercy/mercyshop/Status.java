package com.mercy.mercyshop;

/**
 * Created by Mizuka Anamato on 29/08/2018.
 */

public class Status {
    private String kode;
    private String Nama;
    private String Harga;
    private String sts;

    public Status() {
    }

    public Status(String kode, String nama, String harga, String sts) {
        this.kode = kode;
        Nama = nama;
        Harga = harga;
        this.sts = sts;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }
}
