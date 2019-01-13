package com.mercy.mercyshop;

import android.content.Intent;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RefundFragment extends Fragment {
    private EditText nama;
    private EditText no;
    private EditText alamat;
    private EditText kode;
    private EditText alasan;
    private ProgressBar proces;
    private Button btnrefund;
    private static String URL_Refund ="http://surveyclickon.000webhostapp.com/android_register_login/refund.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ref = inflater.inflate(R.layout.fragment_refund,container,false);

        nama = ref.findViewById(R.id.ipnm);
        no = ref.findViewById(R.id.ipno);
        alamat = ref.findViewById(R.id.ipalm);
        kode = ref.findViewById(R.id.ikd1);
        alasan = ref.findViewById(R.id.ials);
        proces = ref.findViewById(R.id.loading1);
        btnrefund = ref.findViewById(R.id.btnrfn);

        btnrefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Refundbrg();
            }
        });
        return ref;

    }

    private void Refundbrg() {
        proces.setVisibility(View.VISIBLE);
        btnrefund.setVisibility(View.GONE);

        final String nama = this.nama.getText().toString().trim();
        final String no = this.no.getText().toString().trim();
        final String alamat = this.alamat.getText().toString().trim();
        final String kode = this.kode.getText().toString().trim();
        final String alasan= this.alasan.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_Refund,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                Toast.makeText(getActivity(), "Terimakasih Permintaan Refund Akan Segera Di Proses", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), PengembalianFragment.class);
                                intent.putExtra("nama", nama);
                                intent.putExtra("no", no);
                                intent.putExtra("alamat", alamat);
                                intent.putExtra("kode", kode);
                                intent.putExtra("alasan",alasan);
                                proces.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Kesalahan", Toast.LENGTH_SHORT).show();
                            proces.setVisibility(View.GONE);
                            btnrefund.setVisibility(View.VISIBLE);
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Kesalahan Input Mohon Check Kembali pada nama maupun komentar yang kosong"+error.toString(), Toast.LENGTH_SHORT).show();
                proces.setVisibility(View.GONE);
                btnrefund.setVisibility(View.VISIBLE);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama",nama);
                params.put("no",no);
                params.put("alamat",alamat);
                params.put("kode",kode);
                params.put("alasan",alasan);
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
