package com.example.evaluacion2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import BBDD.AdminSQLiteOpenHelper;

public class Clientes_Act extends AppCompatActivity {

    private EditText edcodigo, ednombre, edsalario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_);
        getSupportActionBar().hide();

        edcodigo = (EditText) findViewById(R.id.editTextTextPersonName2);
        ednombre = (EditText) findViewById(R.id.editTextTextPersonName3);
        edsalario = (EditText) findViewById(R.id.editTextTextPersonName4);

    }


    public void guardar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if (!edcodigo.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", edcodigo.getText().toString());
            registro.put("nombre", ednombre.getText().toString());
            registro.put("salario", Integer.parseInt(edsalario.getText().toString()));

            bd.insert("clientes", null, registro);
            bd.close();
            Toast.makeText(this, "Se ha guardado un cliente", Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this, "Debe agregar un codigo", Toast.LENGTH_SHORT).show();
        }

        refresh();

    }

    public void mostrar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if (!codigo.isEmpty()){

            Cursor fila = bd.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo =" + codigo, null);

            if (fila.moveToFirst()){
                ednombre.setText(fila.getString(0));
                edsalario.setText(fila.getString(1));
            }else{
                Toast.makeText(this, "Codigo no encontrado", Toast.LENGTH_SHORT).show();
                refresh();
            }
        }
        else{
            Toast.makeText(this, "Debe agregar un codigo", Toast.LENGTH_SHORT).show();
        }

    }

    public void eliminar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        bd.delete("clientes", "codigo="+codigo, null);
        bd.close();

        Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();

        refresh();

    }

    public void modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty()){

            ContentValues cont = new ContentValues();
            cont.put("codigo", edcodigo.getText().toString());
            cont.put("nombre", ednombre.getText().toString());
            cont.put("salario", edsalario.getText().toString());

            bd.update("clientes", cont, "codigo="+codigo, null);
            Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "No encontrado", Toast.LENGTH_SHORT).show();
        }
        refresh();
    }

    public void refresh(){
        edcodigo.setText("");
        ednombre.setText("");
        edsalario.setText("");
    }


}