package com.example.proyectogestionrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectogestionrutas.modelo.ListaPosiciones;
import com.example.proyectogestionrutas.modelo.ListaTramos;


public class MainActivity extends AppCompatActivity {

    private ListaPosiciones posiciones;
    private ListaTramos tramos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializaVariables();
    }

    public void inicializaVariables() {

        this.posiciones = new ListaPosiciones();
        this.tramos = new ListaTramos();
    }

    public void insertarPos(View view) {

        Intent intent = new Intent(this, PosicionActivity.class);
        startActivityForResult(intent,1);
    }

    public void insertarTramo(View view) {

        Intent intent = new Intent(this, TramoActivity.class);
        startActivityForResult(intent,2);
    }
}