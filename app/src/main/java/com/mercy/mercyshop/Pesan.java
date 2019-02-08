package com.mercy.mercyshop;

/**
 * Created by Mizuka Anamato on 30/08/2018.
 */

public class Pesan {
    private String nm3;
    private String no3;
    private String alamt;
    private String jne;
    private double total;

    public Pesan() {
    }

    public Pesan(String nm3, String no3, String alamt, String jne, double total) {
        this.nm3 = nm3;
        this.no3 = no3;
        this.alamt = alamt;
        this.jne = jne;
        this.total = total;
    }

    public String getNm3() {
        return nm3;
    }

    public void setNm3(String nm3) {
        this.nm3 = nm3;
    }

    public String getNo3() {
        return no3;
    }

    public void setNo3(String no3) {
        this.no3 = no3;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
