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

public class TasImportFragment extends Fragment {
    private AppCompatActivity compact;
    private RecyclerView recyclerView;

    public TasImportFragment() {
    }

    ArrayList<Tas> lsTas = new ArrayList<>();
    RecyclerViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View imp = inflater.inflate(R.layout.fragment_tasimpor,container,false);
        RecyclerView recyclerView = imp.findViewById(R.id.impor);
        GridLayoutManager impManager=new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(impManager);
        mAdapter = new RecyclerViewAdapter(getContext(),lsTas);
        recyclerView.setAdapter(mAdapter);

        findData();
        return imp;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void findData() {
        lsTas.add(new Tas("Tas Pink Mini","Tas Import","Tas Import pink mini yang bisa menyimpan berbagai perlengkapan Kosmetik maupun lainnya",70000,R.drawable.pinkmini));
        lsTas.add(new Tas("Tas ToteBag","Tas Import","Tas Import Totebag yang bisa menyimpan berbagai perlengkapan kebutuhan kampus para remaja ",85000,R.drawable.totebag));
        lsTas.add(new Tas("Tas Totebag fold","Tas Import","Tas Import Fold Totebag yang bisa menyimpan berbagai perlengkapan kebutuhan kampus para remaja",100000,R.drawable.totebagorange));
        lsTas.add(new Tas("Trendy Bag","Tas Import","Tas backpack yang cocok buat kalangan muda dapat menampung barang apapun dan desainnya yang unik membuat penggunanya merasa trendy dengan tas ini",200000,R.drawable.taskeren));
        lsTas.add(new Tas("Yellow Bag","Tas Import","Tas yang bisa di buat totebag atau tas berpergian simple, dengan ukuran tas tinggi 80cm x lebar 50cm. Tas ini mempunyai handphone holder dan di sertai tali yang bisa di gunakan sebagai penggunaan tas berpergian",100000,R.drawable.tasunik));
        lsTas.add(new Tas("Bag Seword Red","Tas Import","Tas import Seword yang terkenal di kalangan para remaja korea dan sempat booming di pakai oleh artis dengan tampungan kapasitas yang cukup besar tas ini menjadi favorite anak - anak kalangan muda di korea",250000,R.drawable.redbag));
        lsTas.add(new Tas("Tas Sekolah Hitam","Tas Import"," Tas Sekolah Import yang bisa menampung berbagai macam buku pelajaranmu dan tahan air di desain dengan bahan kain anti air dengan pilihan warna hitam",100000,R.drawable.backpack));
        mAdapter.notifyDataSetChanged();
    }


}
