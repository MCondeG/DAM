package com.example.gestionrutas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import com.example.gestionrutas.modelo.Posicion;
import com.example.gestionrutas.modelo.colecciones.ListaGlobal;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Toolbar toolbar;
    private AlertDialog dialogo1;
    private AlertDialog dialogo2;

    private ListaGlobal datos = ListaGlobal.getGlobalData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //testing
        datos.getPosiciones().insertar("sevilla", "1", "1");
        datos.getPosiciones().insertar("cadiz", "2", "2");
        datos.getPosiciones().insertar("granada", "3", "3");

        this.inicializaVariables();

        setSupportActionBar(this.toolbar);
    }

    private void inicializaVariables() {

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.dialogo1 = alertDialogConstructor(1).create();
        this.dialogo2 = alertDialogConstructor(2).create();
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
                this.dialogo1.show();
                break;
            case R.id.item2:
                this.dialogo2.show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    // Creación del alert dialog
    @NonNull
    private AlertDialog.Builder alertDialogConstructor(int caso) {

        LayoutInflater inflater = getLayoutInflater();
        View view;
        AlertDialog.Builder builder = null;

        switch (caso) {
            case 1:
                view = inflater.inflate(R.layout.formulario_posicion, null);

                EditText editText1 = (EditText) view.findViewById(R.id.editText1);
                EditText editText2 = (EditText) view.findViewById(R.id.editText2);
                EditText editText3 = (EditText) view.findViewById(R.id.editText3);

                ArrayAdapter<Posicion> spinnerAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, datos.getPosiciones().getListaPosiciones());

                builder = new AlertDialog.Builder(this);
                builder.setTitle("Añadir Posición")
                        .setView(view)
                        .setPositiveButton("OK", (dialog, id)->{
                            String nombre = editText1.getText().toString();
                            String latitud = editText2.getText().toString();
                            String longitud = editText3.getText().toString();

                            datos.getPosiciones().insertar(nombre, latitud, longitud);



                            editText1.setText("");
                            editText2.setText("");
                            editText3.setText("");

                            Toast.makeText(this, "Posicion creada", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Cancelar", (dialog, id)->{dialog.cancel();});
                break;
            case 2:
                view = inflater.inflate(R.layout.formulario_tramo, null);


                spinnerAdapter.notifyDataSetChanged();


                Spinner spinner1 = view.findViewById(R.id.spinner1);
                Spinner spinner2 = view.findViewById(R.id.spinner2);

                spinner1.setAdapter(spinnerAdapter);
                spinner1.setOnItemSelectedListener(this);
                spinner2.setAdapter(spinnerAdapter);
                spinner2.setOnItemSelectedListener(this);

                builder = new AlertDialog.Builder(this);
                builder.setTitle("Añadir Tramo")
                        .setView(view)
                        .setPositiveButton("OK", (dialog, id)->{
                            Posicion pos1 = (Posicion) spinner1.getSelectedItem();
                            Posicion pos2 = (Posicion) spinner2.getSelectedItem();

                            datos.getTramos().insertar(pos1, pos2);

                            Toast.makeText(this, "Tramo creado", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Cancelar", (dialog, id)->{dialog.cancel();});

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + caso);
        }

        return builder;
    }

    /*public void verPosiciones(View view) {

        Intent intent = new Intent(this, TramoActivity.class);
        intent.putExtra("lista posiciones", this.posiciones);
        startActivityForResult(intent,1);
    }*/
}