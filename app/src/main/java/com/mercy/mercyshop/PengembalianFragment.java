package com.mercy.mercyshop;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Mizuka Anamato on 27/08/2018.
 */

public class PengembalianFragment extends Fragment {
    Button re;
    List<Refund> ref = new ArrayList<>();
    private String link ="http://mercyshopper.000webhostapp.com/hrefund.php";
    RefundAdapter Adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View pgmb = inflater.inflate(R.layout.fragment_pengembalian, container, false);
        re = pgmb.findViewById(R.id.rep);

        RecyclerView last =pgmb.findViewById(R.id.href);
        LinearLayoutManager lref = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        Adapter = new RefundAdapter(getContext(),ref);
        last.setLayoutManager(lref);
        last.setAdapter(Adapter);
        data();
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(),ReplyRefund.class);
                getActivity().startActivity(intent);
            }
        });
        return pgmb;
    }

    private void data() {
        final ProgressDialog pDial = new ProgressDialog(getActivity());
        pDial.setMessage("Loading...");
        pDial.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(link, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Refund refund = new Refund();
                        refund.setNama(jsonObject.getString("nama"));
                        refund.setNo(jsonObject.getString("no"));
                        refund.setAlamat(jsonObject.getString("alamat"));
                        refund.setKode(jsonObject.getString("kode"));
                        refund.setAlasan(jsonObject.getString("alasan"));
                        ref.add(refund);
                        Adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        pDial.dismiss();
                    }
                }
                Adapter.notifyDataSetChanged();
                pDial.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley",error.toString());
                pDial.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
