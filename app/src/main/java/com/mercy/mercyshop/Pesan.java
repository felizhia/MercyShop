package com.mercy.mercyshop;

/**
 * Created by Mizuka Anamato on 30/08/2018.
 */

public class Pesan {
    private String nama;
    private String no;
    private String alamt;
    private String jne;
    private String total;
    private String quan;

    public Pesan() {
    }

    public Pesan(String nama, String no, String alamt, String jne, String total,String quan) {
        this.nama = nama;
        this.no = no;
        this.alamt = alamt;
        this.jne = jne;
        this.total = total;
        this.quan = quan;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
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

    public String getAlamt() {
        return alamt;
    }

    public void setAlamt(String alamt) {
        this.alamt = alamt;
    }

    public String getJne() {
        return jne;
    }

    public void setJne(String jne) {
        this.jne = jne;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
