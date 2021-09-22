package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import entidades.Alumno;

public class ListViewPartes extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    List<String> nombres=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_partes);

        //1) Conectar nuestra lista con el componente visual
        lista=(ListView)findViewById(R.id.listView);

        //2) Cargar lista de elementos
        Bundle extras=this.getIntent().getExtras();
        ArrayList<Alumno> alumnos=(ArrayList<Alumno>)extras.getSerializable("alumnos");
        for(Alumno al:alumnos) {
            nombres.add(al.getNombre());
        }

        //3) Adaptador del modelo a la vista (Se estudiara más en profundidad)
        ArrayAdapter adaptador= new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                nombres);

        //4) Vincular el adaptador con el componente visual
        lista.setAdapter(adaptador);

        //5) Crear eventos en los elementos de la lista
        lista.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String linea=nombres.get(position);
        Toast.makeText(this,linea,Toast.LENGTH_LONG).show();
    }

}