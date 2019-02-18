package com.mercy.mercyshop;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class CheckfinalActivity extends AppCompatActivity {
    private List<Product> example =new ArrayList<>();
    private Button belanja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfinal);
        belanja = findViewById(R.id.blnj);

        Intent intent = getIntent();
        String extraname = intent.getStringExtra("nama");
        String extrano = intent.getStringExtra("no");
        String extraalamat = intent.getStringExtra("alamat");
        String extrajne = intent.getStringExtra("jne");
        String extratotal = intent.getStringExtra("total");

        TextView name = findViewById(R.id.vnm);
        TextView no = findViewById(R.id.vno);
        TextView alamat = findViewById(R.id.valm);
        TextView jne = findViewById(R.id.vjs);
        TextView total = findViewById(R.id.vttl);


        name.setText(extraname);
        no.setText(extrano);
        alamat.setText(extraalamat);
        jne.setText(extrajne);
        total.setText(extratotal);

        RecyclerView re = findViewById(R.id.recheck);
        LinearLayoutManager aw3 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ProductAdapter madapter = new ProductAdapter(this, example,getLayoutInflater(),total);
        re.setAdapter(madapter);

        re.setLayoutManager(aw3);



        belanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CheckfinalActivity.this, MainActivity.class));
                KeranjangFragment.example.clear();
            }
        });


    }
}
