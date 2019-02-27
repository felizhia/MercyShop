package com.mercy.mercyshop;

/**
 * Created by Mizuka Anamato on 24/02/2019.
 */

public class Final {
    private String product;
    private String price;

    public Final() {
    }

    public Final(String product, String price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}