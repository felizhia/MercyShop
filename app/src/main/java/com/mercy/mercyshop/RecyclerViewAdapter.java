package com.mercy.mercyshop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import static android.support.constraint.Constraints.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    LayoutInflater inflater;
    int positionbundle;
    ArrayList<Tas> mData;
    SmileRating smileRating;

    public List<Product> example = new ArrayList<>();
    public String title;
    public int productImage;
    public double price;

    public RecyclerViewAdapter(Context mContext, ArrayList<Tas> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cardview_tas, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tas_thumbnail.setImageResource(mData.get(position).getImg());
        holder.ratingBar.setRating(5);
        holder.smileRating.setSelectedSmile(BaseRating.GREAT);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TasActivity.class);
                intent.putExtra("Title", mData.get(position).getTitle());
                intent.putExtra("Category", mData.get(position).getCategory());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Harga", mData.get(position).getHarga());
                intent.putExtra("Img", mData.get(position).getImg());

                mContext.startActivity(intent);
            }
        });
        holder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                KeranjangFragment.example.add(new Product(title,productImage,price));
                li();

                notifyDataSetChanged();
                Toast.makeText(mContext,"Barang "+holder.tv_title.getText()+" di tambahkan ke keranjang",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void li() {
        for (int i = 0;i<example.size();i++){
            example=new Vector<Product>();
            example.add(new Product("Tas Serbaguna Kecil", R.drawable.bagmini, 50000));
            example.add(new Product("Tas Serbaguna Besar", R.drawable.greybag, 70000));
            example.add(new Product("Tas Serbaguna Sedang", R.drawable.bagblack, 120000));
            example.add(new Product("Pouch Wanita Sedang", R.drawable.pouch, 50000));
            example.add(new Product("Tas Pink Mini", R.drawable.pinkmini, 70000));
            example.add(new Product("Tas ToteBag", R.drawable.totebag, 85000));
            example.add(new Product("Tas Totebag fold", R.drawable.totebagorange, 100000));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView tas_thumbnail;
        RatingBar ratingBar;
        SmileRating smileRating;
        CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.texttas);
            tas_thumbnail = itemView.findViewById(R.id.imagetas);
            card = itemView.findViewById(R.id.cardviewid);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            smileRating=itemView.findViewById(R.id.smile_rating);
            ratingBar.setIsIndicator(false);
            smileRating.setIndicator(false);
        }
    }

}
