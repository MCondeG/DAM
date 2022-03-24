package com.example.recuperacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recuperacion1.modelo.ListaPosiciones;
import com.example.recuperacion1.modelo.ListaTramos;

public class MainActivity extends AppCompatActivity {

    private EditText latitud;
    private EditText longitud;

    private ListaPosiciones posiciones;
    private ListaTramos tramos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializaVariables();
    }

    private void inicializaVariables() {

        this.latitud = (EditText) findViewById(R.id.editText1);
        this.longitud = (EditText) findViewById(R.id.editText2);
        this.posiciones = new ListaPosiciones();
        this.tramos = new ListaTramos();
    }


    public void insertarPos(View view) {

        String lat = this.latitud.getText().toString();
        String longi = this.longitud.getText().toString();

        if ((lat != "") && (longi != "")) {
            this.posiciones.añadir(lat, longi);
            Toast.makeText(this, "Posición registrada", Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(this, "Latitud y/o longitud vacías", Toast.LENGTH_LONG).show();
    }

    public void insertarTramo(View view) {

        Intent intent = new Intent(this, TramoActivity.class);
        intent.putExtra("lista posiciones", this.posiciones);
        startActivityForResult(intent,1);
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 1){
            String mensaje=data.getExtras().getString("valor");
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }

     */
}