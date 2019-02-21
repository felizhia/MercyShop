package com.mercy.mercyshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mizuka Anamato on 27/08/2018.
 */

public class PesananFragment extends Fragment {
    List<Pesan> pesn =new ArrayList<>();
    PesananAdapter pa;
    private static String pesanan ="http://192.168.1.7/android_register_login/hpesan.php";
    public PesananFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View psn =  inflater.inflate(R.layout.fragment_pesanan,container,false);


        RecyclerView re = psn.findViewById(R.id.psanan);
        LinearLayoutManager lfc = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        pa = new PesananAdapter(getContext(),pesn);
        re.setAdapter(pa);
        re.setLayoutManager(lfc);

        data();

        return psn;
    }
    private void data() {
        final ProgressDialog pDial = new ProgressDialog(getActivity());
        pDial.setMessage("Loading...");
        pDial.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(pesanan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Pesan pesan = new Pesan();
                        pesan.setNama(jsonObject.getString("nama"));
                        pesan.setNo(jsonObject.getString("no"));
                        pesan.setAlamt(jsonObject.getString("alamat"));
                        pesan.setJne(jsonObject.getString("jne"));
                        pesan.setTotal(jsonObject.getString("total"));
                        pesn.add(pesan);
                        pa.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        pDial.dismiss();
                    }
                }
                pa.notifyDataSetChanged();
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
