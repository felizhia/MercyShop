package com.mercy.mercyshop;

import android.widget.ImageView;

public class Tas {

    private String Title;
    private String Category;
    private String Description;
    private String Harga;
    public int Img;
    public boolean selected;

    public Tas() {
    }

    public Tas(String title, String category, String description, String harga, int img) {
        Title = title;
        Category = category;
        Description = description;
        Harga = harga;
        Img = img;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}
