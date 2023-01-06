package com.example.networks2;

import static com.android.volley.Request.Method.POST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.networks2.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    RequestQueue queue;
    JsonObjectRequest jsonObjectRequest;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    NetworkInfo info;
    ConnectivityManager connectivityManager;
    public static final String TEXT_EMAIL = "email";
    public static final String TEXT_PASSWORD = "password";
    public static final String BASE_URL = "https://studentucas.awamr.com/api/";
    public static final String CHECK_BOX = "";
    public static final String REMEMBER_CUSTOMER = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        queue= Volley.newRequestQueue(LoginActivity.this);




        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

            }
        });


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataLoginDelevary();
            }
        });

    }

    void DataLoginDelevary() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(TEXT_EMAIL, binding.eTEmail.getText().toString());
            jsonObject.put(TEXT_PASSWORD, binding.eTPassword.getText().toString());
            jsonObjectRequest = new JsonObjectRequest(POST,
                    BASE_URL + "auth/login/delivery", jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (response.getBoolean("success")) {

                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            finish();
//                            binding.progressBarCard.setVisibility(View.GONE);
//                            binding.dataLogin.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, response.getString("message"), Toast.LENGTH_SHORT).show();
                        } else {
//                            binding.progressBarCard.setVisibility(View.GONE);
//                            binding.dataLogin.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, response.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        queue.add(jsonObjectRequest);

    }
}