package com.example.proyectogestionrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyectogestionrutas.modelo.ListaPosiciones;

public class PosicionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posicion);

        ListaPosiciones posiciones;
        posiciones = (ListaPosiciones) getIntent().getExtras().getSerializable("lista posiciones");
    }


}