package com.mercy.mercyshop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class KeranjangFragment extends Fragment {
    TextView total;
    Button btnpesan;
    public KeranjangFragment() {
    }

    public static List example = new ArrayList<Product>();
    ProductAdapter madapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View krnjg =inflater.inflate(R.layout.fragment_keranjang,container,false);

        RecyclerView rec = krnjg.findViewById(R.id.rc1);

        LinearLayoutManager aw1 =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rec.setLayoutManager(aw1);


        madapter = new ProductAdapter(getContext(),example,getLayoutInflater());
        rec.setAdapter(madapter);
        madapter.notifyDataSetChanged();
        findData();

        total = krnjg.findViewById(R.id.vtotal);
        btnpesan = krnjg.findViewById(R.id.btnpsn);

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),CheckoutActivity.class));
            }
        });

        return krnjg;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static List<Product> findData(){
        if (example == example) {
            example = new Vector<Product>();
            example.add(new Product("Tas Serbaguna Kecil", R.drawable.bagmini, "50.000"));
            example.add(new Product("Tas Serbaguna Besar", R.drawable.greybag, "70.000"));
            example.add(new Product("Tas Serbaguna Sedang", R.drawable.bagblack, "120.000"));
            example.add(new Product("Pouch Wanita Sedang", R.drawable.pouch, "50.000"));
            example.add(new Product("Tas Pink Mini", R.drawable.pinkmini, "70.000"));
            example.add(new Product("Tas ToteBag", R.drawable.totebag, "85.000"));
            example.add(new Product("Tas Totebag fold", R.drawable.totebagorange, "100.000"));
        }
        return example;
    }

}
