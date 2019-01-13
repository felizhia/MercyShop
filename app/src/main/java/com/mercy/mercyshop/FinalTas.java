package com.mercy.mercyshop;

import java.util.ArrayList;

/**
 * Created by Mizuka Anamato on 26/08/2018.
 */

public class FinalTas {
    private String Product;
    private String Harga1;
    public int img;

    public FinalTas() {
    }

    public FinalTas(String product, String harga1, int img) {
        Product = product;
        Harga1 = harga1;
        this.img = img;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getHarga1() {
        return Harga1;
    }

    public void setHarga1(String harga1) {
        Harga1 = harga1;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
