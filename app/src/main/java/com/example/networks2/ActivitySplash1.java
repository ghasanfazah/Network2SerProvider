package com.example.networks2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networks2.databinding.ActivitySplash1Binding;

public class ActivitySplash1 extends AppCompatActivity {
    ActivitySplash1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplash1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(), ActivitySplash2.class);
                startActivity(intent);
                finish();
            }
        });

    }
}