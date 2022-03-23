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

    private void inicializaVariables() {

        this.posiciones = new ListaPosiciones();
        this.tramos = new ListaTramos();
    }


    public void insertarPos(View view) {

        Intent intent = new Intent(this, PosicionActivity.class);
        intent.putExtra("lista posiciones", this.posiciones);
        startActivityForResult(intent,1);
    }

    public void insertarTramo(View view) {

        Intent intent = new Intent(this, TramoActivity.class);
        intent.putExtra("lista tramos", this.tramos);
        startActivityForResult(intent,2);
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Primer parámetro determina quien envió el primer intent
        //El segundo parámetro identifica el regreso
        if (requestCode==1234 && resultCode==7){
            String mensaje=data.getExtras().getString("valor");
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }*/
}