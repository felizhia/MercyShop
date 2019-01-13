package com.mercy.mercyshop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {
    private Context mContext;
    private List<Status> mData;

    public StatusAdapter(Context mContext, List<Status> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cardview_status, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_title.setText(mData.get(position).getNama());
        holder.tv_harga.setText(mData.get(position).getHarga());
        holder.tv_kode.setText(mData.get(position).getKode());
        holder.sts.setText(mData.get(position).getSts());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_kode;
        TextView tv_harga;
        TextView sts;
        CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.nm1);
            tv_harga = itemView.findViewById(R.id.angka);
            tv_kode = itemView.findViewById(R.id.ktr);
            sts = itemView.findViewById(R.id.sts1);
            card = itemView.findViewById(R.id.carstas);
        }
    }
}
