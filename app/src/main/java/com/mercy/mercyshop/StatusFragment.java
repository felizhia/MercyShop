package com.mercy.mercyshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class StatusFragment extends Fragment {
    private AppCompatActivity compact;
    private RecyclerView recyclerView;

    public StatusFragment() {
    }

    ArrayList<Status> st=new ArrayList<>();
    StatusAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vi =inflater.inflate(R.layout.fragment_status,container,false);
        RecyclerView recyclerView = vi.findViewById(R.id.status);
        LinearLayoutManager aw=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(aw);
        mAdapter = new StatusAdapter(getContext(),st);
        recyclerView.setAdapter(mAdapter);

        findData();
        return vi;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void findData() {
        st.add(new Status("#0001","Elisabeth Virsya","120.000","Terkirim"));
        st.add(new Status("#0002","Elisabeth Virsya","50.000","Pending"));
        st.add(new Status("#0003","Elisabeth Virsya","270.000","Pending"));

        mAdapter.notifyDataSetChanged();
    }
}
