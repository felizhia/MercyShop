package com.mercy.mercyshop;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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

public class StatusFragment extends Fragment {
    private static String pesanan = "http://192.168.1.7/android_register_login/hpesan.php";

    public StatusFragment() {
    }

    List<Status> st=new ArrayList<>();
    StatusAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vi =inflater.inflate(R.layout.fragment_status,container,false);

        RecyclerView recyclerView = vi.findViewById(R.id.status);
        LinearLayoutManager aw=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(aw);
        mAdapter = new StatusAdapter(getContext(),st);
        recyclerView.setAdapter(mAdapter);

        findData();
        return vi;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void findData() {
        final ProgressDialog pDial = new ProgressDialog(getActivity());
        pDial.setMessage("Loading...");
        pDial.show();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(pesanan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Status status = new Status();
                        status.setKode(jsonObject.getString("id"));
                        status.setNama(jsonObject.getString("nama"));
                        status.setHarga(jsonObject.getString("total"));
                        st.add(status);
                        mAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        pDial.dismiss();
                    }
                }
                mAdapter.notifyDataSetChanged();
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
}
