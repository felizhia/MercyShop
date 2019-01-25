package com.mercy.mercyshop;

import android.widget.TextView;

/**
 * Created by Mizuka Anamato on 30/08/2018.
 */

public class Refund {
    private String nama;
    private String no;
    private String alamat;
    private String kode;
    private String alasan;

    public Refund() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }
}