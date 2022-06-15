package com.example.rutas.Entidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.rutas.MainActivity;
import com.example.rutas.R;

import java.util.ArrayList;


public class Ruta extends AppCompatActivity {

    ListView listView, lvRuta;
    ArrayList<String> list;
    EditText rinicio,rfinal;
    Button add,cargar;
    String inicioruta,finalruta;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruta_activity);
        this.setTitle("Ruta");

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView)findViewById(R.id.lvtramo);
        lvRuta =(ListView)findViewById(R.id.lvruta);

        rinicio=(EditText) findViewById(R.id.etRutaInicio);
        rfinal=(EditText) findViewById(R.id.etRutaFinal);

        add=(Button) findViewById(R.id.buttonAddRuta);
        cargar=(Button) findViewById(R.id.buttonCargar);

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarLV();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String RI = (String) (listView.getItemAtPosition(i));
                String RF = (String) (listView.getItemAtPosition(i));

                if (rinicio.getText().toString().isEmpty()){
                    rinicio.setText(RI);
                    System.out.println(RI);
                }else if (!rinicio.getText().toString().isEmpty()) {
                    rfinal.setText(RF);
                    System.out.println(RF);

                    System.out.println(rinicio.getText().toString()+" "+rfinal.getText().toString());
                }
            }
        });


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);

                if (!rinicio.getText().toString().isEmpty()&&!rfinal.getText().toString().isEmpty()){
                    inicioruta =rinicio.getText().toString();
                    finalruta=rfinal.getText().toString();
                    list.add(inicioruta+(" ")+finalruta);
                    lvRuta.setAdapter(arrayAdapter);
                    arrayAdapter.notifyDataSetChanged();

                }else
                {
                    Toast.makeText(Ruta.this, "No puede dejar campos vacíos", Toast.LENGTH_SHORT).show();

                }

            }
        });



    }//ON CREATE


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.tramo:
                irATramo();
                break;
            case R.id.posicion:
                irAPosicion();
                break;

            case R.id.inicio:
                irAInicio();
                break;
            case R.id.ruta:
                irARuta();
                break;
        }
        return true;
    }

    public void irARuta(){
        Intent intent = new Intent(this,Ruta.class);
        startActivity(intent);
    }

    public void irATramo(){
        Intent intent = new Intent(this,Tramo.class);
        startActivity(intent);
    }
    public void irAPosicion(){
        Intent intent = new Intent(this,Posicion.class);
        startActivity(intent);
    }
    public void irAInicio(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void cargarLV(){
        list= new ArrayList<String>();
        ArrayList<String> list = getIntent().getStringArrayListExtra("key2");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }
}
