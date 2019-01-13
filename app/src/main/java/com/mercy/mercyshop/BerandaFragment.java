package com.mercy.mercyshop;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BerandaFragment extends Fragment {
    private AppCompatActivity compact;
    private RecyclerView recyclerView;

    public BerandaFragment(){

    }

    ArrayList<Tas> lsTas = new ArrayList<>();
    RecyclerViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_beranda,container,false);
        RecyclerView recyclerView = rootview.findViewById(R.id.recyclerviewtas);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerViewAdapter(getContext(),lsTas);
        recyclerView.setAdapter(mAdapter);

        fillData();
        return rootview;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void fillData() {
        lsTas.add(new Tas("Tas Serbaguna Kecil","Tas Local","Tas yang serbaguna kecil yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari","50.000",R.drawable.bagmini));
        lsTas.add(new Tas("Tas Serbaguna Besar","Tas Local","Tas yang serbaguna besar yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari","70.000",R.drawable.greybag));
        lsTas.add(new Tas("Tas Serbaguna Sedang","Tas Local","Tas yang serbaguna sedang yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari","120.000",R.drawable.bagblack));
        lsTas.add(new Tas("Pouch Wanita Sedang","Dompet","Dompet Import unik cocok untuk para remaja masa kini","50.000",R.drawable.pouch));
        lsTas.add(new Tas("Tas Pink Mini","Tas Import","Tas Import pink mini yang bisa menyimpan berbagai perlengkapan Kosmetik maupun lainnya","70.000",R.drawable.pinkmini));
        lsTas.add(new Tas("Tas ToteBag","Tas Import","Tas Import Totebag yang bisa menyimpan berbagai perlengkapan kebutuhan kampus para remaja ","85.000",R.drawable.totebag));
        lsTas.add(new Tas("Tas Totebag fold","Tas Import","Tas Import Fold Totebag yang bisa menyimpan berbagai perlengkapan kebutuhan kampus para remaja","100.000",R.drawable.totebagorange));

        mAdapter.notifyDataSetChanged();
    }

}
