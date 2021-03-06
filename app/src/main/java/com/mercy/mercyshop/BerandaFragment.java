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
        lsTas.add(new Tas("Tas Serbaguna Kecil","Tas Local","Tas yang serbaguna kecil yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari",50000,R.drawable.bagmini));
        lsTas.add(new Tas("Tas Serbaguna Besar","Tas Local","Tas yang serbaguna besar yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari",70000,R.drawable.greybag));
        lsTas.add(new Tas("Tas Serbaguna Sedang","Tas Local","Tas yang serbaguna sedang yang bisa menyimpan berbagai perlengkapan kebutuhan sehari - hari",120000,R.drawable.bagblack));
        lsTas.add(new Tas("Pouch Wanita Sedang","Tas Local","Dompet Import unik cocok untuk para remaja masa kini",50000,R.drawable.pouch));
        lsTas.add(new Tas("Tas Pink Mini","Tas Import","Tas Import pink mini yang bisa menyimpan berbagai perlengkapan Kosmetik maupun lainnya",70000,R.drawable.pinkmini));
        lsTas.add(new Tas("Tas ToteBag","Tas Import","Tas Import Totebag yang bisa menyimpan berbagai perlengkapan kebutuhan kampus para remaja ",85000,R.drawable.totebag));
        lsTas.add(new Tas("Tas Totebag fold","Tas Import","Tas Import Fold Totebag yang bisa menyimpan berbagai perlengkapan kebutuhan kampus para remaja",100000,R.drawable.totebagorange));
        lsTas.add(new Tas("Tas Sekolah Hitam","Tas Import"," Tas Sekolah Import yang bisa menampung berbagai macam buku pelajaranmu dan tahan air di desain dengan bahan kain anti air dengan pilihan warna hitam",100000,R.drawable.backpack));
        lsTas.add(new Tas("Backpack Trendy","Tas Local","Backpack Trendy buat semua umur cocok di pakai dari anak kecil sampai dewasa mampu menampung berbagai macam buku, alat, apapun kebutuhan anda tersedia dengan warna hitam uk size tinggi 100cm x lebar 50 cm",130000,R.drawable.backpackhitam));
        lsTas.add(new Tas("Triangle Cute","Tas Local","Tas berbentuk segitiga ini sedang booming di korea dengan bentuknya yang lucu dan kapasitas yang cukup banyak",50000,R.drawable.triangle));
        lsTas.add(new Tas("Mini Purple Bag","Tas Local","Tas mini yang cocok di buat bepergian kemanapun indoor maupun outdoor dengan tampilan minimalis dan elegan. Tas ini mampu menampung banyak item yang para wanita butuhkan",80000,R.drawable.purplebag));
        lsTas.add(new Tas("Trendy Bag","Tas Import","Tas backpack yang cocok buat kalangan muda dapat menampung barang apapun dan desainnya yang unik membuat penggunanya merasa trendy dengan tas ini",200000,R.drawable.taskeren));
        lsTas.add(new Tas("Yellow Bag","Tas Import","Tas yang bisa di buat totebag atau tas berpergian simple, dengan ukuran tas tinggi 80cm x lebar 50cm. Tas ini mempunyai handphone holder dan di sertai tali yang bisa di gunakan sebagai penggunaan tas berpergian",100000,R.drawable.tasunik));
        lsTas.add(new Tas("Bag Seword Red","Tas Import","Tas import Seword yang terkenal di kalangan para remaja korea dan sempat booming di pakai oleh artis dengan tampungan kapasitas yang cukup besar tas ini menjadi favorite anak - anak kalangan muda di korea",250000,R.drawable.redbag));
        mAdapter.notifyDataSetChanged();
    }

}
