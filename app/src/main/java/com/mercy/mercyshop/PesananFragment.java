package com.mercy.mercyshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mizuka Anamato on 27/08/2018.
 */

public class PesananFragment extends Fragment {
    private ArrayList<FinalTas> lsTas;
    public PesananFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View psn =  inflater.inflate(R.layout.fragment_pesanan,container,false);
        lsTas = new ArrayList<>();
        lsTas.add(new FinalTas("Tas Pink Mini","70.000",R.drawable.pinkmini));
        lsTas.add(new FinalTas("Tas ToteBag","85.000",R.drawable.totebag));
        lsTas.add(new FinalTas("Tas Totebag fold","100.000",R.drawable.totebagorange));

        RecyclerView re = psn.findViewById(R.id.recheck);
        RecyclerViewLAdapter ad = new RecyclerViewLAdapter(getContext(),lsTas);
        re.setAdapter(ad);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));

        Intent intent = getActivity().getIntent();
        String extraname = intent.getStringExtra("nama");
        String extrano = intent.getStringExtra("no");
        String extraalamat = intent.getStringExtra("alamat");
        String extrajne = intent.getStringExtra("jne");
        String extratotal = intent.getStringExtra("total");
        TextView name = psn.findViewById(R.id.vnm);
        TextView no = psn.findViewById(R.id.vno);
        TextView alamat = psn.findViewById(R.id.valm);
        TextView jne = psn.findViewById(R.id.vjs);
        TextView total = psn.findViewById(R.id.vttl);
        name.setText(extraname);
        no.setText(extrano);
        alamat.setText(extraalamat);
        jne.setText(extrajne);
        total.setText(extratotal);
        return psn;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
