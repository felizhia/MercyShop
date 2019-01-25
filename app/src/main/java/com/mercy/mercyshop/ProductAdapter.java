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
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.support.v4.app.Fragment.instantiate;
import static com.mercy.mercyshop.KeranjangFragment.example;

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
        Locale locale = new Locale("in","ID");

        NumberFormat formatrupiah = NumberFormat.getCurrencyInstance(locale);
        holder.nmPro.setText(mData.get(position).getTitle());
        holder.imge.setImageResource(mData.get(position).getProductImage());
        holder.hrg.setText(formatrupiah.format(mData.get(position).getPrice()));
        holder.cd.setActivated(mData.get(position).selected);
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.remove(holder.getAdapterPosition());
                double sub = 0;
                for (int i = 1; i<example.size();i++){

                    sub -= example.get(i).getPrice();
                }
                notifyDataSetChanged();
                Toast.makeText(mCon,"Barang "+holder.nmPro.getText()+" di hapus dari keranjang",Toast.LENGTH_SHORT).show();
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
        TextView vt;
        ImageView del;

        public MyViewHolder(View itemView) {
            super(itemView);
            nmPro = itemView.findViewById(R.id.barang);
            imge = itemView.findViewById(R.id.pict);
            hrg = itemView.findViewById(R.id.hrga);
            cd = itemView.findViewById(R.id.cardker);
            vt = itemView.findViewById(R.id.vtotal);
            del = itemView.findViewById(R.id.del);
        }

    }
}
