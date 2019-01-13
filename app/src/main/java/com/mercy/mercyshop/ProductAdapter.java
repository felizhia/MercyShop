package com.mercy.mercyshop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mizuka Anamato on 13/09/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context mCon;
    List<Product> mData;
    LayoutInflater mla;

    public ProductAdapter(Context mCon, List<Product> mData, LayoutInflater mla) {
        this.mCon = mCon;
        this.mData = mData;
        this.mla = mla;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater minf = LayoutInflater.from(parent.getContext());
        View a = minf.inflate(R.layout.cardview_keranjang,parent,false);
        MyViewHolder ab = new MyViewHolder(a);
        return ab;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.nmPro.setText(mData.get(position).getTitle());
        holder.imge.setImageResource(mData.get(position).getProductImage());
        holder.hrg.setText( mData.get(position).getPrice());
        holder.cd.setActivated(mData.get(position).selected);
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nmPro;
        ImageView imge;
        TextView hrg;
        CardView cd;
        ImageView del;

        public MyViewHolder(View itemView) {
            super(itemView);
            nmPro = itemView.findViewById(R.id.barang);
            imge = itemView.findViewById(R.id.pict);
            hrg = itemView.findViewById(R.id.hrga);
            cd = itemView.findViewById(R.id.cardker);
            del = itemView.findViewById(R.id.del);
        }

    }
}
