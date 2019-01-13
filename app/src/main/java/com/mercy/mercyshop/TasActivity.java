package com.mercy.mercyshop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hsalf.smilerating.SmileRating;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class TasActivity extends AppCompatActivity {
    private TextView tvtitle,tvcategory,tvdesc,tvhrg,nama,hrg;
    private ImageView img;
    private Button btnblnja;
    private RatingBar rating;
    private SmileRating smile;

    public static List example = new ArrayList<Product>();
    public String title;
    public int productImage;
    public String price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas);

        tvtitle=findViewById(R.id.judultas);
        tvcategory=findViewById(R.id.kategori);
        tvdesc=findViewById(R.id.deskripsi);
        tvhrg = findViewById(R.id.harga);
        img=findViewById(R.id.tasthumbnail);
        btnblnja = findViewById(R.id.tambahbelanja);
        rating = findViewById(R.id.ratingBar);
        smile = findViewById(R.id.smile_rating);

        btnblnja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeranjangFragment.example.add(new Product(title,productImage,price));
                example.contains(title);
                example.contains(productImage);
                example.contains(price);
                finish();
            }
        });

        Intent intent= getIntent();
        String Title = intent.getExtras().getString("Title");
        String Category = intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Description");
        String Harga = intent.getExtras().getString("Harga");
        int image = intent.getExtras().getInt("Img");

        tvtitle.setText(Title);
        tvcategory.setText(Category);
        tvdesc.setText(Description);
        tvhrg.setText(Harga);
        img.setImageResource(image);



    }
    public static List<Product> findData(){
        if (example == null) {
            example = new Vector<Product>();
            example.add(new Product("Tas Serbaguna Kecil", R.drawable.bagmini, "50.000"));
            example.add(new Product("Tas Serbaguna Besar", R.drawable.greybag, "70.000"));
            example.add(new Product("Tas Serbaguna Sedang", R.drawable.bagblack, "120.000"));
            example.add(new Product("Pouch Wanita Sedang", R.drawable.pouch, "50.000"));
            example.add(new Product("Tas Pink Mini", R.drawable.pinkmini, "70.000"));
            example.add(new Product("Tas ToteBag", R.drawable.totebag, "85.000"));
            example.add(new Product("Tas Totebag fold", R.drawable.totebagorange, "100.000"));
        }
        return example;
    }

}
