package com.example.networks2;

import static com.android.volley.Request.Method.POST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.networks2.databinding.ActivityRegisterBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    JsonObjectRequest jsonObjectRequest;

    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        queue= Volley.newRequestQueue(RegisterActivity.this);

        binding.buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getApplicationContext(), LoginActivity.class));

            }
        });



    }


    void put(){

        JSONObject jsonObject =new JSONObject();
        try {

            jsonObject.put("email",binding.eTFName.getText().toString());
            jsonObject.put("password",binding.eTEmail.getText().toString());
            jsonObject.put("password",binding.eTNumber.getText().toString());
            jsonObject.put("password",binding.eTPassword.getText().toString());


            jsonObjectRequest=new JsonObjectRequest(POST,
                    "http://studentucas.awamr.com/api/auth/register/user",
                    jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //رساله اذا نجح
                    try {
                        Toast.makeText(RegisterActivity.this,response.getString("message"), Toast.LENGTH_SHORT).show();

                        if (response.getBoolean("success")==true){
                            Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }





                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegisterActivity.this, ""+ error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
        queue.add(jsonObjectRequest);

    }
    }