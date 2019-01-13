package com.mercy.mercyshop;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class CheckfinalActivity extends AppCompatActivity {
    private ArrayList<FinalTas> lsTas;
    private Button belanja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfinal);

        belanja = findViewById(R.id.blnj);

        lsTas = new ArrayList<>();
        lsTas.add(new FinalTas("Tas Pink Mini","70.000",R.drawable.pinkmini));
        lsTas.add(new FinalTas("Tas ToteBag","85.000",R.drawable.totebag));
        lsTas.add(new FinalTas("Tas Totebag fold","100.000",R.drawable.totebagorange));

        RecyclerView re = findViewById(R.id.recheck);
        RecyclerViewLAdapter ad = new RecyclerViewLAdapter(this,lsTas);
        re.setAdapter(ad);
        re.setLayoutManager(new LinearLayoutManager(this));

        belanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CheckfinalActivity.this,MainActivity.class));
            }
        });

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
    }
}
