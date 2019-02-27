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

import java.util.List;

/**
 * Created by Mizuka Anamato on 24/02/2019.
 */

public class FinalTasAdapter extends RecyclerView.Adapter<FinalTasAdapter.MyViewHolder> {
    private Context mCon;
    List<Final> mData;

    public FinalTasAdapter(Context mCon, List<Final> mData) {
        this.mCon = mCon;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mif = LayoutInflater.from(parent.getContext());
        View pl = mif.inflate(R.layout.cardview_finaltas,parent,false);
        MyViewHolder aa = new MyViewHolder(pl);
        return aa;
    }

    @Override
    public void onBindViewHolder(@NonNull FinalTasAdapter.MyViewHolder holder, int position) {
        Final prod = mData.get(position);
        holder.product.setText(mData.get(position).getProduct());
        holder.price.setText(mData.get(position).getPrice());
        holder.cdr.setEnabled(true);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView product;
        TextView price;
        CardView cdr;
        public MyViewHolder(View itemView) {
            super(itemView);
            product= itemView.findViewById(R.id.product);
            price=itemView.findViewById(R.id.price);
            cdr = itemView.findViewById(R.id.finalcrd);
        }
    }
}
