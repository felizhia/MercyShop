package com.mercy.mercyshop;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Mizuka Anamato on 13/09/2018.
 */

public class Product {
    public String title;
    public int productImage;
    public double price;
    public boolean selected;

    public Product() {

    }

    public Product(String title, int productImage, double
            price) {
        this.title = title;
        this.productImage = productImage;
        this.price = price;
    }

    public Product(String product, String title) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double  price) {
        this.price = price;
    }
}
