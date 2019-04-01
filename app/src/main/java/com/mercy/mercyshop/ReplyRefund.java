package com.mercy.mercyshop;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mizuka Anamato on 27/03/2019.
 */

public class ReplyRefund extends AppCompatActivity {
    private static String URL_REPLY ="http://mercyshopper.000webhostapp.com/reply.php";
    private ProgressBar proses;
    private EditText rep;
    private Button Balas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replyrefund);
        proses = findViewById(R.id.pro);
        rep = findViewById(R.id.reps);
        Balas = findViewById(R.id.btnbalas);
        
        Balas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                balas();
            }
        });
    }

    private void balas() {
        proses.setVisibility(View.VISIBLE);
        Balas.setVisibility(View.GONE);

        final String reply= this.rep.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REPLY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                Intent intent = new Intent(ReplyRefund.this,KomentarFragment.class);
                                intent.putExtra("reply", reply);
                                Toast.makeText(ReplyRefund.this, "Pesan Terkirim", Toast.LENGTH_SHORT).show();
                                proses.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ReplyRefund.this, "Kesalahan, Mohon Check Kembali", Toast.LENGTH_SHORT).show();
                            proses.setVisibility(View.GONE);
                            Balas.setVisibility(View.VISIBLE);
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ReplyRefund.this, "Kesalahan Input Mohon Check Kembali Nama Dan Komentar", Toast.LENGTH_SHORT).show();
                proses.setVisibility(View.GONE);
                Balas.setVisibility(View.VISIBLE);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("reply",reply);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
