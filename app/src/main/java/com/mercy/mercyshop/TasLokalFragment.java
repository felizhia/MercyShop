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
        lsTas.add(new Tas("Pouch Wanita Sedang","Tas Local","Dompet Import unik cocok untuk para remaja masa kini",50000,R.drawable.pouch));
        lsTas.add(new Tas("Backpack Trendy","Tas Local","Backpack Trendy buat semua umur cocok di pakai dari anak kecil sampai dewasa mampu menampung berbagai macam buku, alat, apapun kebutuhan anda tersedia dengan warna hitam uk size tinggi 100cm x lebar 50 cm",130000,R.drawable.backpackhitam));
        lsTas.add(new Tas("Triangle Cute","Tas Local","Tas berbentuk segitiga ini sedang booming di korea dengan bentuknya yang lucu dan kapasitas yang cukup banyak",50000,R.drawable.triangle));
        lsTas.add(new Tas("Mini Purple Bag","Tas Local","Tas mini yang cocok di buat bepergian kemanapun indoor maupun outdoor dengan tampilan minimalis dan elegan. Tas ini mampu menampung banyak item yang para wanita butuhkan",80000,R.drawable.purplebag));
        mAdapter.notifyDataSetChanged();
    }
}
