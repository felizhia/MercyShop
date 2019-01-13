package com.mercy.mercyshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class KomplainFragment extends Fragment {
    private EditText nama;
    private EditText komentar;
    private ProgressBar proses;
    private Button btn;
    private static String URL_KOMEN ="http://surveyclickon.000webhostapp.com/android_register_login/komen.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_komplain,container,false);
        nama = v.findViewById(R.id.nama1);
        komentar = v.findViewById(R.id.textlay);
        proses = v.findViewById(R.id.progress);
        btn = v.findViewById(R.id.btnkomen);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Komentar();
            }
        });
        return v;

    }

    private void Komentar() {
        proses.setVisibility(View.VISIBLE);
        btn.setVisibility(View.GONE);

        final String nama= this.nama.getText().toString().trim();
        final String komentar = this.komentar.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_KOMEN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                Toast.makeText(getActivity(), "Terimakasih Atas Komentar Anda, Komentar Anda Akan Sangat Membantu Kami", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(),KomentarFragment.class);
                                intent.putExtra("nama", nama);
                                intent.putExtra("komen",komentar);
                                startActivity(intent);
                                proses.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Kesalahan"+e.toString(), Toast.LENGTH_SHORT).show();
                            proses.setVisibility(View.GONE);
                            btn.setVisibility(View.VISIBLE);
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Kesalahan Input Mohon Check Kembali pada nama maupun komentar yang kosong"+error.toString(), Toast.LENGTH_SHORT).show();
                proses.setVisibility(View.GONE);
                btn.setVisibility(View.VISIBLE);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama",nama);
                params.put("komen",komentar);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
