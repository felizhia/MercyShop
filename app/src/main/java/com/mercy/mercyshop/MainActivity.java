package com.mercy.mercyshop;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView mNavigationView = findViewById(R.id.nav_view);
        View headerView = mNavigationView.getHeaderView(0);
        Intent intent = getIntent();
        TextView name = headerView.findViewById(R.id.nama);
        TextView email = headerView.findViewById(R.id.mail);
        String extraName = intent.getStringExtra("name");
        String extraEmail = intent.getStringExtra("email");
        name.setText(extraName);
        email.setText(extraEmail);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar
                ,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BerandaFragment()).commit();
            mNavigationView.setCheckedItem(R.id.nav_beranda);
        }

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_beranda:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BerandaFragment()).commit();
                        break;
                    case R.id.nav_taslokal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TasLokalFragment()).commit();
                        break;
                    case R.id.nav_tasimport:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TasImportFragment()).commit();
                        break;
                    case R.id.nav_status:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new StatusFragment()).commit();
                        break;
                    case R.id.nav_belanja:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new KeranjangFragment()).commit();
                        break;
                    case R.id.nav_komplain:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new KomplainFragment()).commit();
                        break;
                    case R.id.nav_refund:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RefundFragment()).commit();
                        break;
                    case R.id.nav_pengaturan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PengaturanFragment()).commit();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });


    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
