package com.mercy.mercyshop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mizuka Anamato on 27/03/2019.
 */

public class CheckFragment extends Fragment {
    private TextView hs1,hs2,hs3,hs4,hs5,hs6,hs7,hs8,hs9,hs10,hs11,hs12,hs13,hs14,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View chek =  inflater.inflate(R.layout.checkstok,container,false);
        hs1=chek.findViewById(R.id.hstok1);
        hs2=chek.findViewById(R.id.hstok2);
        hs3=chek.findViewById(R.id.hstok3);
        hs4=chek.findViewById(R.id.hstok4);
        hs5=chek.findViewById(R.id.hstok5);
        hs6=chek.findViewById(R.id.hstok6);
        hs7=chek.findViewById(R.id.hstok7);
        hs8=chek.findViewById(R.id.hstok8);
        hs9=chek.findViewById(R.id.hstok9);
        hs10=chek.findViewById(R.id.hstok10);
        hs11=chek.findViewById(R.id.hstok11);
        hs12=chek.findViewById(R.id.hstok12);
        hs13=chek.findViewById(R.id.hstok13);
        hs14=chek.findViewById(R.id.hstok14);
        s1=chek.findViewById(R.id.stok1);
        s2=chek.findViewById(R.id.stok2);
        s3=chek.findViewById(R.id.stok3);
        s4=chek.findViewById(R.id.stok4);
        s5=chek.findViewById(R.id.stok5);
        s6=chek.findViewById(R.id.stok6);
        s7=chek.findViewById(R.id.stok7);
        s8=chek.findViewById(R.id.stok8);
        s9=chek.findViewById(R.id.stok9);
        s10=chek.findViewById(R.id.stok10);
        s11=chek.findViewById(R.id.stok11);
        s12=chek.findViewById(R.id.stok12);
        s13=chek.findViewById(R.id.stok13);
        s14=chek.findViewById(R.id.stok14);

        return chek;
    }
}
