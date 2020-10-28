package com.example.evaluacion2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Info_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);
        getSupportActionBar().hide();
    }
}