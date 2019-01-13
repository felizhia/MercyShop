package com.mercy.mercyshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CheckoutActivity extends AppCompatActivity {
    private EditText nama,no,alamat,jne;
    private ProgressBar pro;
    private Button btncheck;
    private static String URL_CHECK="http://192.168.1.2/android_register_login/check.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        nama = findViewById(R.id.ipnm);
        no = findViewById(R.id.ipno);
        alamat = findViewById(R.id.ipalm);
        jne = findViewById(R.id.ijasa);
        pro = findViewById(R.id.proses);
        btncheck = findViewById(R.id.btncheck);



        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkout();
                final String mnama= nama.getText().toString();
                final String mno= no.getText().toString();
                final String malamat= alamat.getText().toString();
                final String mjne=jne.getText().toString();

                Intent intent = new Intent(CheckoutActivity.this, CheckfinalActivity.class);
                intent.putExtra("nama", mnama);
                intent.putExtra("no", mno);
                intent.putExtra("alamat", malamat);
                intent.putExtra("jne", mjne);
                Intent intent1 = new Intent(CheckoutActivity.this, PesananFragment.class);
                intent1.putExtra("nama", mnama);
                intent1.putExtra("no", mno);
                intent1.putExtra("alamat", malamat);
                intent1.putExtra("jne", mjne);
                startActivity(intent);

            }
        });
    }

     private void checkout() {
        pro.setVisibility(View.VISIBLE);
        btncheck.setVisibility(View.GONE);

        final String nama= this.nama.getText().toString().trim();
        final String no= this.no.getText().toString().trim();
        final String alamat= this.alamat.getText().toString().trim();
        final String jne= this.jne.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CHECK,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                Toast.makeText(CheckoutActivity.this, "Terimakasih Sudah Berbelanja di Mercy Shop", Toast.LENGTH_SHORT).show();
                                pro.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(CheckoutActivity.this, "Kesalahan"+e.toString(), Toast.LENGTH_SHORT).show();
                            pro.setVisibility(View.GONE);
                            btncheck.setVisibility(View.VISIBLE);
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CheckoutActivity.this, "Kesalahan Input Mohon Check Kembali"+error.toString(), Toast.LENGTH_SHORT).show();
                pro.setVisibility(View.GONE);
                btncheck.setVisibility(View.VISIBLE);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama",nama);
                params.put("no",no);
                params.put("alamat",alamat);
                params.put("jne",jne);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}