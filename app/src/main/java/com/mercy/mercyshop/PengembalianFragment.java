package com.mercy.mercyshop;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

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

/**
 * Created by Mizuka Anamato on 27/08/2018.
 */

public class PengembalianFragment extends Fragment {
    public  static String urlString ="";
    private View v;

    RecyclerView lala;
    JsonArrayRequest jsonArrayRequest;
    ArrayList<Refund> li = new ArrayList<>();
    RefundAdapter mAdapter;
    RequestQueue requestQueue;

    public PengembalianFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View pgmb = inflater.inflate(R.layout.fragment_pengembalian, container, false);

        Intent intent = getActivity().getIntent();
        String extraname = intent.getStringExtra("nama");
        String extrano = intent.getStringExtra("no");
        String extraalamat = intent.getStringExtra("alamat");
        String extrakode = intent.getStringExtra("kode");
        String extraalasan = intent.getStringExtra("alasan");
        TextView name = pgmb.findViewById(R.id.kmn1);
        TextView no = pgmb.findViewById(R.id.noval);
        TextView alamat = pgmb.findViewById(R.id.sno);
        TextView kode = pgmb.findViewById(R.id.kode1);
        TextView alasan = pgmb.findViewById(R.id.valsn);
        name.setText(extraname);
        no.setText(extrano);
        alamat.setText(extraalamat);
        kode.setText(extrakode);
        alasan.setText(extraalasan);

        new AsyncFetch().execute();
        return pgmb;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private class AsyncFetch extends AsyncTask<String, String, String> {

        ProgressDialog pDialog = new ProgressDialog(getActivity());
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog.setMessage("Loading list ...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                // Enter URL address where your json file resides
                // Even you can make call to php file which returns json data
                url = new URL("http://surveyclickon.000webhostapp.com/android_register_login/back.php");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }
            try {

                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");

                // setDoOutput to true as we recieve data from json file
                conn.setDoOutput(true);

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }
            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            pDialog.dismiss();

            try{
                JSONObject object = new JSONObject(result);
                int code = object.getInt("refund");
                if(code == 0) {
                    JSONArray jsonArray = object.getJSONArray("refund");
                    ArrayList<Refund> ref = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Refund refund = new Refund();
                        refund.setNm(jsonObject.getString("nama"));
                        refund.setNo(jsonObject.getString("no"));
                        refund.setAlam(jsonObject.getString("alamat"));
                        refund.setKode(jsonObject.getString("kode"));
                        refund.setAlas(jsonObject.getString("alasan"));
                        ref.add(refund);
                    }
                }
            }catch (JSONException e) {

                e.printStackTrace();
                Toast.makeText(getActivity(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    }
}
