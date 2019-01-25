package com.mercy.mercyshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TasLokalFragment extends Fragment {
    private AppCompatActivity compact;
    private RecyclerView recyclerView;

    public TasLokalFragment() {
    }

    ArrayList<Tas> lsTas = new ArrayList<>();
    RecyclerViewAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View lcl = inflater.inflate(R.layout.fragment_taslokal,container,false);
        RecyclerView recyclerView = lcl.findViewById(R.id.rwlocal);
        GridLayoutManager localManager=new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(localManager);
        mAdapter = new RecyclerViewAdapter(getContext(),lsTas);
        recyclerView.setAdapter(mAdapter);

        findData();
        return lcl;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void findData() {
        lsTas.add(new Tas("Tas Serbaguna Kecil","Tas Local","Tas yang serbaguna kecil yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari",50000,R.drawable.bagmini));
        lsTas.add(new Tas("Tas Serbaguna Besar","Tas Local","Tas yang serbaguna besar yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari",70000,R.drawable.greybag));
        lsTas.add(new Tas("Tas Serbaguna Sedang","Tas Local","Tas yang serbaguna sedang yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari",120000,R.drawable.bagblack));

        mAdapter.notifyDataSetChanged();
    }
}
