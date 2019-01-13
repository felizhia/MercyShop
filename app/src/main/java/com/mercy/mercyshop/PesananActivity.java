package com.mercy.mercyshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class PesananActivity extends AppCompatActivity {
    private TextView tvnm3,tvno3,tvalmt1,tvjne,tvtotal;
    private RecyclerView re;
    private ArrayList<FinalTas> fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        tvnm3 = findViewById(R.id.vnm);
        tvno3 = findViewById(R.id.vno);
        tvalmt1 = findViewById(R.id.valm);
        tvjne = findViewById(R.id.vjs);
        tvtotal = findViewById(R.id.vttl);
        re = findViewById(R.id.recheck1);

        Intent intent = getIntent();
        String nm3 = intent.getExtras().getString("nm3");
        String no3 = intent.getExtras().getString("no3");
        String almt1 = intent.getExtras().getString("almt1");
        String jne = intent.getExtras().getString("jne");
        String total = intent.getExtras().getString("total");

        tvnm3.setText(nm3);
        tvno3.setText(no3);
        tvalmt1.setText(almt1);
        tvjne.setText(jne);
        tvtotal.setText(total);

        fl = new ArrayList<>();
        fl.add(new FinalTas("Tas Serbaguna Sedang","120.000",R.drawable.bagblack));
        fl.add(new FinalTas("Pouch Wanita Sedang","50.000",R.drawable.pouch));
        fl.add(new FinalTas("Tas Pink Mini","70.000",R.drawable.pinkmini));

        re= findViewById(R.id.recheck1);
        LinearLayoutManager fa = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        RecyclerViewLAdapter la = new RecyclerViewLAdapter(this,fl);
        re.setHasFixedSize(false);
        re.setLayoutManager(fa);
        re.setAdapter(la);
    }
}
