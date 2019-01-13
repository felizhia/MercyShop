package com.mercy.mercyshop;

import android.widget.TextView;

/**
 * Created by Mizuka Anamato on 30/08/2018.
 */

public class Refund {
    private String nm;
    private String no;
    private String alam;
    private String kode;
    private String alas;

    public Refund() {
    }

    public Refund(String nm, String no, String alam, String kode, String alas) {
        this.nm = nm;
        this.no = no;
        this.alam = alam;
        this.kode = kode;
        this.alas = alas;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAlam() {
        return alam;
    }

    public void setAlam(String alam) {
        this.alam = alam;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getAlas() {
        return alas;
    }

    public void setAlas(String alas) {
        this.alas = alas;
    }
}
