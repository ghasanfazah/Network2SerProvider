package com.example.networks2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            int secondsDelayed = 1;

    // كلاس handler بتستقبل مسج



        new Handler().postDelayed(new Runnable() {
        public void run() {
            Intent intent=new Intent(getApplicationContext(), ActivitySplash1.class);
            startActivity(intent);
            finish();
        }
    }, secondsDelayed * 1000);



    }
}