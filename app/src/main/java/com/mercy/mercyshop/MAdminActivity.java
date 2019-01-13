package com.mercy.mercyshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MAdminActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madmin);


        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_lyt);

        NavigationView navigationView = findViewById(R.id.nav_view1);
        View headerView = navigationView.getHeaderView(0);
        Intent intent = getIntent();
        TextView name = headerView.findViewById(R.id.nama1);
        TextView email = headerView.findViewById(R.id.mail1);
        String extraName = intent.getStringExtra("name");
        String extraEmail = intent.getStringExtra("email");
        name.setText(extraName);
        email.setText(extraEmail);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar
                ,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,new JualFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_jual);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_jual:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1, new JualFragment()).commit();
                        break;
                    case R.id.nav_pesanan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1, new PesananFragment()).commit();
                        break;
                    case R.id.nav_komplainuser:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1, new KomentarFragment()).commit();
                        break;
                    case R.id.nav_refund1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1, new PengembalianFragment()).commit();
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(MAdminActivity.this,LoginActivity.class));
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
