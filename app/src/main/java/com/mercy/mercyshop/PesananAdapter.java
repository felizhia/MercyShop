package com.mercy.mercyshop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.MyViewHolder> {
    private Context mContext;
    private List<Pesan> mData;

    public PesananAdapter(Context mContext, List<Pesan> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cardview_pesanan, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Pesan pesan =mData.get(position);
        holder.nama.setText(mData.get(position).getNama());
        holder.no.setText(mData.get(position).getNo());
        holder.alamat.setText(mData.get(position).getAlamt());
        holder.jne.setText(mData.get(position).getJne());
        holder.total.setText(mData.get(position).getTotal());
        holder.card.setEnabled(true);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        TextView no;
        TextView alamat;
        TextView jne;
        TextView total;
        CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.vnm2);
            no = itemView.findViewById(R.id.vno2);
            alamat = itemView.findViewById(R.id.valm2);
            jne = itemView.findViewById(R.id.vjs2);
            total = itemView.findViewById(R.id.vttl2);
            card = itemView.findViewById(R.id.cardpsn);
        }
    }
}
