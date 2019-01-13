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

public class RecyclerViewLAdapter extends RecyclerView.Adapter<RecyclerViewLAdapter.MyViewHolder> {
    private Context mContext;
    private List<FinalTas> mData;

    public RecyclerViewLAdapter(Context context, ArrayList<FinalTas> list) {
        mContext = context;
        mData = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cardview_final, parent, false);
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
                Intent intent = new Intent(mContext, TasActivity.class);
                intent.putExtra("Product", mData.get(position).getProduct());
                intent.putExtra("Harga1", mData.get(position).getHarga1());
                intent.putExtra("img", mData.get(position).getImg());
                mContext.startActivity(intent);
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
            tv_harga = itemView.findViewById(R.id.ktr);
            tas_thumbnail = itemView.findViewById(R.id.gbr);
            card = itemView.findViewById(R.id.cardker2);
        }
    }
}
