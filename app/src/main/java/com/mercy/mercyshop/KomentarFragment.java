package com.mercy.mercyshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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
 * Created by Mizuka Anamato on 27/02/2019.
 */

public class KomentarFragment extends Fragment {
    Button reply;
    List<Komen> ko = new ArrayList<>()  ;
    private String link = "http://mercyshopper.000webhostapp.com/hkomen.php";
    KomentarAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View kom =  inflater.inflate(R.layout.fragment_komentar,container,false);
        reply = kom.findViewById(R.id.repl);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReplyKomen.class);
                getActivity().startActivity(intent);
            }
        });
        RecyclerView rec = kom.findViewById(R.id.moment);
        LinearLayoutManager aw1 =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        adapter = new KomentarAdapter(getContext(),ko);
        rec.setLayoutManager(aw1);
        rec.setAdapter(adapter);
        getData();
        return kom;
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(link, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Komen komen = new Komen();
                        komen.setNama(jsonObject.getString("nama"));
                        komen.setKomen(jsonObject.getString("komen"));
                        ko.add(komen);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }

                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
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
