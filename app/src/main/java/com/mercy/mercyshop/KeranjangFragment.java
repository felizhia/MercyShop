package com.mercy.mercyshop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import static android.media.CamcorderProfile.get;

public class KeranjangFragment extends Fragment {
    TextView total;
    Button btnpesan;
    String tr;
    public KeranjangFragment() {
    }

    public static List<Product> example = new ArrayList<>();
    ProductAdapter madapter;

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
                startActivity(new Intent(getActivity(),CheckoutActivity.class));
            }
        });

        return krnjg;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
