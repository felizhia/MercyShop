package com.mercy.mercyshop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LAdminActivity extends AppCompatActivity {
    private EditText name,email, password;
    private Button btnadmin;
    private ProgressBar loading;
    private static String URL_LOGIN = "http://mercyshopper.000webhostapp.com/admin.php";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        loading = findViewById(R.id.load);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
        btnadmin = findViewById(R.id.btnadmin);

        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail=email.getText().toString().trim();
                String mPass=password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPass.isEmpty()){
                    Login(mEmail, mPass);
                }else{
                    email.setError("Please Insert E-mail");
                    password.setError("Please Insert Password");
                }
            }
        });


    }
    private void setFirstTimeStartStatus(boolean stt){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag", stt);
        editor.commit();
    }

    private void Login(final String email, final String password) {
        loading.setVisibility(View.VISIBLE);
        btnadmin.setVisibility(View.GONE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("admin");

                            if (success.equals("1")){

                                for (int i=0; i<jsonArray.length();i++){
                                    JSONObject object= jsonArray.getJSONObject(i);
                                    String name = object.getString("name").trim();
                                    Toast.makeText(LAdminActivity.this, "Login Berhasil. \nSelamat Datang Admin : "+name, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LAdminActivity.this, MAdminActivity.class);
                                    intent.putExtra("name", name);
                                    intent.putExtra("email", email);
                                    startActivity(intent);
                                    setFirstTimeStartStatus(false);
                                    loading.setVisibility(View.GONE);


                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            loading.setVisibility(View.GONE);
                            btnadmin.setVisibility(View.VISIBLE);
                            Toast.makeText(LAdminActivity.this, "Error Check Kembali Email dan Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.setVisibility(View.GONE);
                btnadmin.setVisibility(View.VISIBLE);
                Toast.makeText(LAdminActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email",email);
                params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
