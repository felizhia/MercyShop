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
    private List<Refund> mData;

    public RefundAdapter(Context mContext, List<Refund> mData) {
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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Refund refund = mData.get(position);
        holder.rnama.setText(mData.get(position).getNama());
        holder.rno.setText(mData.get(position).getNo());
        holder.rkode.setText(mData.get(position).getKode());
        holder.ralm.setText(mData.get(position).getAlamat());
        holder.ralsn.setText(mData.get(position).getAlasan());
        holder.rcard.setEnabled(true);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView rnama;
        TextView rno;
        TextView ralm;
        TextView rkode;
        TextView ralsn;
        CardView rcard;

        public MyViewHolder(View itemView) {
            super(itemView);
            rnama = itemView.findViewById(R.id.namar2);
            rno = itemView.findViewById(R.id.nor2);
            ralm=itemView.findViewById(R.id.almtr2);
            rkode =itemView.findViewById(R.id.koder2);
            ralsn=itemView.findViewById(R.id.alsnr2);
            rcard = itemView.findViewById(R.id.refundc);
        }
    }
}
