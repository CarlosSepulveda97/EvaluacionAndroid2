package com.example.evaluacion2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import Models.Cliente;
import Models.Prestamo;

public class HOME_ACT extends AppCompatActivity{

    private ViewFlipper vf;
    private long[] images = {R.mipmap.a, R.mipmap.b, R.mipmap.c};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_o_m_e__a_c_t);
        getSupportActionBar().hide();

        vf = (ViewFlipper) findViewById(R.id.slider);

        for(int i= 0; i < images.length; i++)
        {
            flip_image((int) images[i]);
        }

    }

    private void flip_image(int image) {

        ImageView view = new ImageView(this);

        view.setBackgroundResource(image);


        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void clientes(View view){
        Intent intent = new Intent(this, Clientes_Act.class);
        startActivity(intent);
    }

    public void prestamos(View view){

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

        clientes.add(new Cliente("Axel",750000));
        clientes.add(new Cliente("Roxana",900000));

        prestamos.add(new Prestamo("CREDITO HIPOTECARIO", 1000000, 12));
        prestamos.add(new Prestamo("CREDITO AUTOMOTRIZ", 500000, 8));


        Intent intent = new Intent(this, Prestamos_Act.class);
        intent.putExtra("listaClientes", clientes);
        intent.putExtra("listaPrestamos", prestamos);
        startActivity(intent);
    }

    public void seguridad(View view){
        Intent intent = new Intent(this, Seguridad_Act.class);
        startActivity(intent);
    }

    public void informacion(View view){
        Intent intent = new Intent(this, Info_Act.class);
        startActivity(intent);
    }




}