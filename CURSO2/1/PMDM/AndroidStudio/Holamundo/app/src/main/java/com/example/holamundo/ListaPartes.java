package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import entidades.Alumno;

public class ListaPartes extends AppCompatActivity {

    ListView listaPartes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partes);
        Bundle extras=this.getIntent().getExtras();


        ArrayList<Alumno> alumnos=(ArrayList<Alumno>)extras.getSerializable("alumnos");

        TextView texto=findViewById(R.id.textView2);
        String cadena="";
        for(Alumno al:alumnos){
            cadena+=al.getNombre()+" \n";
        }
        texto.setText(cadena);
    }

    public void botonPulsado(View view) {


    }
}