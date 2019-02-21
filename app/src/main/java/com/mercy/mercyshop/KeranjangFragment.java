package com.mercy.mercyshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
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
    TextView total;
    Button btnpesan;
    String tr;
    private static String URL_pesan ="http://192.168.1.7/android_register_login/product.php";

    public KeranjangFragment() {
    }

    public static List<Product> example = new ArrayList<>();
    ProductAdapter madapter;
    public TextView title;
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

        Map<String,String> params = new HashMap<>();
        params.put("product", String.valueOf(title));
        params.put("price", String.valueOf(price));

        JSONObject parameters = new JSONObject();
        JSONArray products = new JSONArray();
        for(Product p:example){
            JSONObject prod = new JSONObject();
            try {
                prod.put("product",p.getTitle());
                prod.put("price",p.getPrice());
                products.put(prod);
                parameters.put("products",products);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

       JsonObjectRequest keranjang = new JsonObjectRequest(Request.Method.POST,URL_pesan,parameters,  new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                System.out.println();
                try{
                    String success = response.getString("success");
                        /*Intent intent = new Intent(getActivity(),CheckfinalActivity.class);
                        intent.putExtra("product", title);
                        intent.putExtra("price",price);
                        startActivity(intent);
                        String title = response.getString("product");
                        String price = response.getString("price");*/
                    Toast.makeText(getActivity(), "Tersimpan", Toast.LENGTH_SHORT).show();
                    madapter.notifyDataSetChanged();
                    pDial.dismiss();
                        /*Product product = new Product();
                        product.setTitle(jsonObject.getString("product"));
                        product.setPrice(jsonObject.getDouble("price"));
                        example.add(product);
                        total.setText((int) jsonObject.getDouble("total"));*/
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
       },new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               error.printStackTrace();
               Toast.makeText(getActivity(), "Tidak dapat menyimpan", Toast.LENGTH_SHORT).show();
               pDial.dismiss();
           }
       });
        Volley.newRequestQueue(getActivity()).add(keranjang);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
