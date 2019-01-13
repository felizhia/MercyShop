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

import java.util.ArrayList;
import java.util.List;

public class RefundAdapter extends RecyclerView.Adapter<RefundAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Refund> mData;

    public RefundAdapter(Context mContext, ArrayList<Refund> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cardview_refund, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_title.setText(mData.get(position).getNm());
        holder.tv_no.setText(mData.get(position).getNo());
        holder.tv_kode.setText(mData.get(position).getKode());
        holder.tv_alm.setText(mData.get(position).getAlam());
        holder.tv_alsn.setText(mData.get(position).getAlas());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_no;
        TextView tv_alm;
        TextView tv_kode;
        TextView tv_alsn;
        CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.kmn1);
            tv_no = itemView.findViewById(R.id.noval);
            tv_alm=itemView.findViewById(R.id.sno);
            tv_kode =itemView.findViewById(R.id.kode1);
            tv_alsn=itemView.findViewById(R.id.valsn);
            card = itemView.findViewById(R.id.cardrefund);
        }
    }
}
