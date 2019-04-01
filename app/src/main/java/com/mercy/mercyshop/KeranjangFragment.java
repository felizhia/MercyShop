package com.mercy.mercyshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static android.media.CamcorderProfile.get;

public class KeranjangFragment extends Fragment {
    private EditText product,prices;
    TextView total;
    Button btnpesan;
    String tr;
    private static String URL_pesan ="http://mercyshopper.000webhostapp.com/product.php";

    public KeranjangFragment() {
    }

    public static List<Product> example = new ArrayList<>();
    ProductAdapter madapter;
    public String title;
    public TextView quanti;
    public int productImage;
    public double price;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View krnjg =inflater.inflate(R.layout.fragment_keranjang,container,false);

        RecyclerView rec = krnjg.findViewById(R.id.rc1);
        LinearLayoutManager aw1 =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rec.setLayoutManager(aw1);


        total = krnjg.findViewById(R.id.vtotal);
        madapter = new ProductAdapter(getContext(), example, getLayoutInflater(), total);
        rec.setAdapter(madapter);
        product = krnjg.findViewById(R.id.barang);
        prices = krnjg.findViewById(R.id.hrga);
        quanti = krnjg.findViewById(R.id.hquan);
        btnpesan = krnjg.findViewById(R.id.btnpsn);


        Locale locale = new Locale("in","ID");

        NumberFormat formatrupiah = NumberFormat.getCurrencyInstance(locale);
        total.setText(formatrupiah.format(madapter.getTotalPrice()));

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeorder();
                final String mtotal = total.getText().toString();
                Intent intent = new Intent(getActivity(), CheckoutActivity.class);
                intent.putExtra("total",mtotal);
                startActivity(intent);
            }
        });

        return krnjg;
    }

    private void placeorder() {
        final ProgressDialog pDial = new ProgressDialog(getActivity());
        pDial.setMessage("Loading...");
        pDial.show();

        final String product = madapter.getproduct();
        final String prices = madapter.getprice();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_pesan,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                Intent intent = new Intent(getActivity(), CheckoutActivity.class);
                                intent.putExtra("product", product);
                                intent.putExtra("price", prices);

                                Toast.makeText(getActivity(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
                                pDial.dismiss();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                            pDial.dismiss();
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Tidak Dapat Menyimpan", Toast.LENGTH_SHORT).show();
                pDial.dismiss();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("product",product);
                params.put("price",prices);
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
