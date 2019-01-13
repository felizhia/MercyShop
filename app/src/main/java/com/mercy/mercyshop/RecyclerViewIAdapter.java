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

public class RecyclerViewIAdapter extends RecyclerView.Adapter<RecyclerViewIAdapter.MyViewHolder> {
    private Context mContext;
    private List<FinalTas> mData;

    public RecyclerViewIAdapter(Context mContext, List<FinalTas> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cardview_keranjang, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_title.setText(mData.get(position).getProduct());
        holder.tv_harga.setText(mData.get(position).getHarga1());
        holder.tas_thumbnail.setImageResource(mData.get(position).getImg());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_harga;
        ImageView tas_thumbnail;
        CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.product);
            tv_harga = itemView.findViewById(R.id.hrga);
            tas_thumbnail = itemView.findViewById(R.id.pict);
            card = itemView.findViewById(R.id.cardker);
        }
    }

}
