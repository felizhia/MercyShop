package com.mercy.mercyshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
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
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class CheckoutActivity extends AppCompatActivity {
    private EditText nama,no,alamat,jne,jmlh;
    private Spinner spin;
    private ProgressBar pro;
    private Button btncheck;
    public String title;
    public int productImage;
    public double price;
    private static String URL_CHECK="http://mercyshopper.000webhostapp.com/check.php";

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
        spin = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.provinsi, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spin.setAdapter(adapter);

        Intent intent = getIntent();
        String extrajmlh = intent.getStringExtra("total");
        jmlh = findViewById(R.id.vttl1);
        jmlh.setText(extrajmlh);

        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkout();
                final String mnama= nama.getText().toString();
                final String mno= no.getText().toString();
                final String malamat= alamat.getText().toString();
                final String mjne=jne.getText().toString();
                final String mttl = jmlh.getText().toString();

                Intent intent = new Intent(CheckoutActivity.this, CheckfinalActivity.class);
                intent.putExtra("nama", mnama);
                intent.putExtra("no", mno);
                intent.putExtra("alamat", malamat);
                intent.putExtra("jne", mjne);
                intent.putExtra("total", mttl);
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
        final String jmlh = this.jmlh.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CHECK,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                Intent intent = new Intent(CheckoutActivity.this, CheckfinalActivity.class);
                                intent.putExtra("nama", nama);
                                intent.putExtra("no", no);
                                intent.putExtra("alamat", alamat);
                                intent.putExtra("jne", jne);
                                intent.putExtra("total",jmlh);
                                Toast.makeText(CheckoutActivity.this, "Terimakasih Sudah Berbelanja di Mercy Shop", Toast.LENGTH_SHORT).show();
                                pro.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(CheckoutActivity.this, "Kesalahan", Toast.LENGTH_SHORT).show();
                            pro.setVisibility(View.GONE);
                            btncheck.setVisibility(View.VISIBLE);
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CheckoutActivity.this, "Kesalahan Input Mohon Check Kembali", Toast.LENGTH_SHORT).show();
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
                params.put("total",jmlh);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
