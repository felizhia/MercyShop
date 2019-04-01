package com.mercy.mercyshop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static android.support.v4.app.Fragment.instantiate;

/**
 * Created by Mizuka Anamato on 13/09/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context mCon;
    List<Product> mData;
    LayoutInflater mla;
    TextView tvTotal;
    double quantity;

    public ProductAdapter(Context mCon, List<Product> mData, LayoutInflater mla, TextView total) {
        this.mCon = mCon;
        this.mData = mData;
        this.mla = mla;
        this.tvTotal = total;
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
        Product product = mData.get(position);
        Locale locale = new Locale("in","ID");

        final NumberFormat formatrupiah = NumberFormat.getCurrencyInstance(locale);
        holder.nmPro.setText(mData.get(position).getTitle());
        holder.imge.setImageResource(mData.get(position).getProductImage());
        holder.hrg.setText(formatrupiah.format(mData.get(position).getPrice()));
        holder.cd.setActivated(mData.get(position).selected);
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
                tvTotal.setText(formatrupiah.format(getTotalPrice()));
                Toast.makeText(mCon,"Barang "+holder.nmPro.getText()+" di hapus dari keranjang",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < mData.size(); ++i) {
            quantity *= totalPrice;
            totalPrice = totalPrice + mData.get(i).getPrice() + 10000;
        }
        return quantity;
    }

    public String getproduct(){
        String product = new String();
        for (int i = 0; i < mData.size(); ++i) {
            product = mData.get(i).getTitle();
        }
        return product;
    }
    public String getprice(){
        String price = new String();
        for (int i = 0; i < mData.size(); ++i) {
            price = String.valueOf(mData.get(i).getPrice());
        }
        return price;
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
        TextView quantity;

        public MyViewHolder(View itemView) {
            super(itemView);
            nmPro = itemView.findViewById(R.id.barang);
            imge = itemView.findViewById(R.id.pict);
            hrg = itemView.findViewById(R.id.hrga);
            cd = itemView.findViewById(R.id.cardker);
            del = itemView.findViewById(R.id.del);
            quantity = itemView.findViewById(R.id.hquan);
        }

    }
}
