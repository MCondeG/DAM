package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.menu.modelo.ListaPosiciones;
import com.example.menu.modelo.ListaTramos;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AlertDialog dialogo;

    private ListaPosiciones posiciones;
    private ListaTramos tramos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializaVariables();

        setSupportActionBar(this.toolbar);
    }

    private void inicializaVariables() {

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.dialogo = alertDialogConstructor().create();

        this.posiciones = new ListaPosiciones();
        this.tramos = new ListaTramos();
    }


    // Creación del menu de la toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item1:
                this.dialogo.show();
                break;
            case R.id.item2:
                Toast.makeText(this, "evento 2", Toast.LENGTH_SHORT).show();
                //provisional, pendiente de implementar
                break;
        }
        return true;
    }


    // Creación del alert dialog
    @NonNull
    private AlertDialog.Builder alertDialogConstructor() {

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.formulario_insertar_posicion,null);

        EditText editText1 = (EditText) view.findViewById(R.id.editText1);
        EditText editText2 = (EditText) view.findViewById(R.id.editText2);
        EditText editText3 = (EditText) view.findViewById(R.id.editText3);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Añadir Posición")
                .setView(view)
                .setPositiveButton("OK", (dialog, id)->{
                    String nombre = editText1.getText().toString();
                    String latitud = editText2.getText().toString();
                    String longitud = editText3.getText().toString();
                    this.posiciones.añadir(nombre, latitud, longitud);
                    Toast.makeText(this, "Posicion creada", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancelar", (dialog, id)->{dialog.cancel();});

        return builder;
    }

    /*public void verPosiciones(View view) {

        Intent intent = new Intent(this, TramoActivity.class);
        intent.putExtra("lista posiciones", this.posiciones);
        startActivityForResult(intent,1);
    }*/
}