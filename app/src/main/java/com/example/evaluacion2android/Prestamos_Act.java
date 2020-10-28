package com.example.evaluacion2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Prestamos_Act extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_);
        getSupportActionBar().hide();




    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}