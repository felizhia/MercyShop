package com.mercy.mercyshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private EditText name,email,password,cpassword;
    private Button btnRegister;
    private ProgressBar loading;
    private static String URL_REGIST="http://mercyshopper.000webhostapp.com/register.php";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loading=findViewById(R.id.loading);
        btnRegister=findViewById(R.id.btnRegister);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();
            }
        });
    }

    private void Regist(){
        loading.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.GONE);

        final String name= this.name.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password=this.password.getText().toString().trim();

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                Toast.makeText(RegisterActivity.this, "Silahkan Check Email Untuk Validasi", Toast.LENGTH_SHORT).show();
                                loading.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(RegisterActivity.this, "Registrasi Gagal!", Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btnRegister.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, "Registrasi Gagal!, Check E-mail dan Password", Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btnRegister.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name",name);
                params.put("email",email);
                params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
