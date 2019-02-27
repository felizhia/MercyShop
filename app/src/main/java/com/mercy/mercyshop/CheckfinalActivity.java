package com.mercy.mercyshop;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class CheckfinalActivity extends AppCompatActivity {
    private List<Final> ex =new ArrayList<>();
    private Button belanja;
    private static String hasil ="http://mercyshopper.000webhostapp.com/hproduct.php";

    FinalTasAdapter xadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfinal);
        belanja = findViewById(R.id.blnj);

        RecyclerView re = findViewById(R.id.chery);
        LinearLayoutManager cheryl = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        xadapter = new FinalTasAdapter(this, ex);
        re.setAdapter(xadapter);
        re.setLayoutManager(cheryl);

        data();

        Intent intent = getIntent();
        String extraname = intent.getStringExtra("nama");
        String extrano = intent.getStringExtra("no");
        String extraalamat = intent.getStringExtra("alamat");
        String extrajne = intent.getStringExtra("jne");
        String extratotal = intent.getStringExtra("total");

        TextView name = findViewById(R.id.vnm);
        TextView no = findViewById(R.id.vno);
        TextView alamat = findViewById(R.id.valm);
        TextView jne = findViewById(R.id.vjs);
        TextView total = findViewById(R.id.vttl);


        name.setText(extraname);
        no.setText(extrano);
        alamat.setText(extraalamat);
        jne.setText(extrajne);
        total.setText(extratotal);





        belanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CheckfinalActivity.this, MainActivity.class));
                KeranjangFragment.example.clear();
            }
        });


    }
    private void data() {
        final ProgressDialog pDial = new ProgressDialog(this);
        pDial.setMessage("Loading...");
        pDial.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(hasil, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Final prod = new Final();
                        prod.setProduct(jsonObject.getString("product"));
                        prod.setPrice(jsonObject.getString("price"));
                        ex.add(prod);
                        xadapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        pDial.dismiss();
                    }
                }
                xadapter.notifyDataSetChanged();
                pDial.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley",error.toString());
                pDial.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
