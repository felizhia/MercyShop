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

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Pesan> mData;

    public PesananAdapter(Context mContext, ArrayList<Pesan> mData) {
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
        holder.tv_nm3.setText(mData.get(position).getNm3());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,PesananActivity.class);
                intent.putExtra("nm3",mData.get(position).getNm3());
                intent.putExtra("no3",mData.get(position).getNo3());
                intent.putExtra("almt1",mData.get(position).getAlamt());
                intent.putExtra("jne",mData.get(position).getJne());
                intent.putExtra("total",mData.get(position).getTotal());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nm3;
        CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_nm3 = itemView.findViewById(R.id.kmn1);
            card = itemView.findViewById(R.id.cardpsn);
        }
    }
}