package com.example.rutas.Entidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.rutas.MainActivity;
import com.example.rutas.Fragment.PosicionFragment;
import com.example.rutas.R;

import java.util.ArrayList;

public class Posicion extends AppCompatActivity {

    Button btnadd,bfragment;
    EditText nombre,coordenada;
    String pnombre,pcoordenada;
    ListView listview;
    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.posicion_activity);
        this.setTitle("Posición");

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list= new ArrayList<String>();
        bfragment=(Button)findViewById(R.id.buttonFragment);
        btnadd=(Button) findViewById(R.id.buttonAdd);



        nombre=(EditText) findViewById(R.id.etNombre);
        coordenada=(EditText) findViewById(R.id.etCoordenada);
        listview=(ListView)findViewById(R.id.listviewPosicion);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);

                if (!nombre.getText().toString().isEmpty()&&!coordenada.getText().toString().isEmpty()){

                pnombre =nombre.getText().toString();
                pcoordenada=coordenada.getText().toString();
                list.add(pnombre +(" Coordenada: ")+ pcoordenada);
                listview.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(Posicion.this, "No puede dejar campos vacíos", Toast.LENGTH_SHORT).show();

                }
            }
        });








        bfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle datos = new Bundle();
                datos.putString("nombre",nombre.getText().toString());
                datos.putString("coordenada",coordenada.getText().toString());

                PosicionFragment fragment = new PosicionFragment();
                fragment.setArguments(datos);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragmentdatos,fragment)
                        .commit();

            }
        });



    }//ON CREATE
    private void devolverResults() {
        Intent intent = new Intent(this, MainActivity.class);

        if (list.isEmpty()){
            Toast.makeText(this,"La lista está vacía",Toast.LENGTH_SHORT).show();
        }else {
            intent.putStringArrayListExtra("key", list);
            setResult(7, intent);
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.tramo:
                enviarListViewaTramos();
                break;
            case R.id.posicion:
                añadeposicion();
                break;

                case R.id.inicio:
                devolverResults();
                break;
            case R.id.ruta:
                irARuta();
                break;
        }
        return true;
    }





    public void añadeposicion(){
        Intent intent = new Intent(this,Posicion.class);
        startActivity(intent);
    }


    public void enviarListViewaTramos(){
        if (list.isEmpty()){
            Toast.makeText(getApplicationContext(),"La lista está vacía",Toast.LENGTH_SHORT).show();
        }else {
            Intent intentT = new Intent(Posicion.this, Tramo.class);
            intentT.putStringArrayListExtra("key2", list);
            startActivity(intentT);
        }
    }

  public void   irARuta(){
        Intent intent = new Intent(this,Ruta.class);
        startActivity(intent);
    }

}
