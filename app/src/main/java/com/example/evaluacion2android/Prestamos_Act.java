package com.example.evaluacion2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;

import Models.Cliente;
import Models.Prestamo;

public class Prestamos_Act extends AppCompatActivity{

    private Spinner spinClientes, spinCreditos;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_);
        getSupportActionBar().hide();

        spinClientes = (Spinner) findViewById(R.id.spinner);
        spinCreditos = (Spinner) findViewById(R.id.spinner2);
        tv = (TextView) findViewById(R.id.textView2);

        ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<Prestamo> listaCreditos = (ArrayList<Prestamo>) getIntent().getSerializableExtra("listaPrestamos");

        ArrayList<String> listaNombres = new ArrayList<String>();
        ArrayList<String> listaPrestamos = new ArrayList<String>();


        for (Cliente cli: listaClientes) {
            listaNombres.add(cli.getNombre());
        }

        for (Prestamo pres: listaCreditos) {
            listaPrestamos.add(pres.getNombrePrestamo());
        }

        ArrayAdapter<String> adapterCli = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNombres);
        ArrayAdapter<String> adapterPres = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPrestamos);

        spinClientes.setAdapter(adapterCli);
        spinCreditos.setAdapter(adapterPres);

    }

    public void calcularPrestamo(View view){
        ArrayList<Integer> datos = calcular();
        tv.setText(datos.get(0) +"");

    }

    public void calcularDeudas(View view){
        ArrayList<Integer> datos = calcular();
        tv.setText((datos.get(0)/datos.get(1)) +"");
    }



    private ArrayList<Integer> calcular(){
        String cliente = spinClientes.getSelectedItem().toString();
        String credito = spinCreditos.getSelectedItem().toString();

        Cliente cliSelect = new Cliente("",0);
        Prestamo presSelect = new Prestamo("",0,0);

        for (Cliente cli: (ArrayList<Cliente>) getIntent().getSerializableExtra("listaClientes")) {
            if (cliente.equals(cli.getNombre())){
                cliSelect = cli;
            }
        }

        for (Prestamo prestamo: (ArrayList<Prestamo>) getIntent().getSerializableExtra("listaPrestamos")){
            if (credito.equals(prestamo.getNombrePrestamo())){
                presSelect = prestamo;
            }
        }

        int resultado = cliSelect.getSaldo() + presSelect.getValorPrestamo();

        ArrayList<Integer> datos = new ArrayList<>();
        datos.add(resultado);
        datos.add(presSelect.getCuotas());

        return datos;
    }

}