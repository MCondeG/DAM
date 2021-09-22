package main.control.ejercicio1_manuelconde;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import modelo.daos.*;
import modelo.entidades.*;

public class ListViewPartes extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private ArrayList<Parte> partes;
    private ArrayList<String> nombres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_partes);

        inicio();
    }


    private void inicio() {

        this.nombres = new ArrayList<>();

        Bundle extra = (Bundle)this.getIntent().getExtras();
        this.partes = (ArrayList<Parte>)extra.getSerializable("partes");

        for(Parte p:this.partes) {
            this.nombres.add(p.getNombreAlumno());
        }

        this.lista = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombres);

        this.lista.setAdapter(adaptador);

        this.lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        String linea = "ALUMNO: ";
        linea = linea.concat(this.nombres.get(position));

        linea = linea.concat("\nEXPULSIÓN: ");
        if (this.partes.get(position).isExpulsion()) linea = linea.concat("Si");
        else linea = linea.concat("No");

        linea = linea.concat("\nINCIDENCIAS: ");
        if (this.partes.get(position).isIncidencia1()) linea = linea.concat("Molestar   ");
        if (this.partes.get(position).isIncidencia2()) linea = linea.concat("Violencia   ");
        if (this.partes.get(position).isIncidencia3()) linea = linea.concat("Sin deberes");


        Toast.makeText(this, linea, Toast.LENGTH_LONG).show();
    }

    public void volver(View v) {

        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}