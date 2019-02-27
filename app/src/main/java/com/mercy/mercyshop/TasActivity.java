package com.mercy.mercyshop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
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
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

public class TasActivity extends AppCompatActivity {
    private static final String TAG ="" ;
    private TextView tvtitle,tvcategory,tvdesc,tvhrg,nama,hrg,mRatingScale;
    private Button btnblnja;
    private ImageView tvimg;
    private RatingBar rating;
    private SmileRating smile;

    public static List example = new ArrayList<Product>();
    public String title;
    public int productImage;
    public double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas);

        Locale locale = new Locale("in","ID");

        NumberFormat formatrupiah = NumberFormat.getCurrencyInstance(locale);
        tvtitle=findViewById(R.id.judultas);
        tvcategory=findViewById(R.id.kategori);
        tvdesc=findViewById(R.id.deskripsi);
        tvhrg = findViewById(R.id.harga);
        tvimg = findViewById(R.id.tasthumbnail);
        btnblnja = findViewById(R.id.tambahbelanja);
        rating = findViewById(R.id.ratingBar1);
        smile = findViewById(R.id.smile_rating1);

        Intent intent= getIntent();
        title = intent.getExtras().getString("Title");
        String Category = intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Description");
        price = intent.getExtras().getDouble("Harga");
        productImage = intent.getExtras().getInt("Img");

        tvtitle.setText(title);
        tvimg.setImageResource(productImage);
        tvcategory.setText(Category);
        tvdesc.setText(Description);
        tvhrg.setText(formatrupiah.format(price));

        smile.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                smiley = smile.getSelectedSmile();
                switch (smiley) {
                    case SmileRating.BAD:
                        Log.i(TAG, "Bad");
                        break;
                    case SmileRating.GOOD:
                        Log.i(TAG, "Good");
                        break;
                    case SmileRating.GREAT:
                        Log.i(TAG, "Great");
                        break;
                    case SmileRating.OKAY:
                        Log.i(TAG, "Okay");
                        break;
                    case SmileRating.TERRIBLE:
                        Log.i(TAG, "Terrible");
                        break;
                }
            }
        });

        btnblnja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeranjangFragment.example.add(new Product(title, productImage, price));
                finish();
            }
        });
    }
}
