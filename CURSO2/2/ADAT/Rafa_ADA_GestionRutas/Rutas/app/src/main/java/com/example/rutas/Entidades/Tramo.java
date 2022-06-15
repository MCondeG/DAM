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

public class Tramo extends AppCompatActivity {


    ListView listView, lvTramo;
    ArrayList<String> list;
    EditText tinicio,tfinal;
    Button add,cargar;
    String iniciotramo,finaltramo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tramo_activity);
        this.setTitle("Tramos");

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView)findViewById(R.id.lvpos);
        lvTramo =(ListView)findViewById(R.id.lvtramo);

        tinicio=(EditText)findViewById(R.id.etTramoInicio);
        tfinal=(EditText)findViewById(R.id.etTramoFinal);
        add=(Button)findViewById(R.id.buttonAddTramo);
        cargar=(Button)findViewById(R.id.buttonCargar);

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarLV();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String TI = (String) (listView.getItemAtPosition(i));
                String TF = (String) (listView.getItemAtPosition(i));

                if (tinicio.getText().toString().isEmpty()){
                    tinicio.setText(TI);
                    System.out.println(TI);
                }else if (!tinicio.getText().toString().isEmpty()) {
                    tfinal.setText(TF);
                    System.out.println(TF);

                    System.out.println(tinicio.getText().toString()+" "+tfinal.getText().toString());
                }
            }
        });



      add.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View view) {
              ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);

              if (!tinicio.getText().toString().isEmpty()&&!tfinal.getText().toString().isEmpty()){
                  iniciotramo =tinicio.getText().toString();
                  finaltramo =tfinal.getText().toString();
                  list.add(iniciotramo+(" ")+finaltramo);
                  lvTramo.setAdapter(arrayAdapter);
                  arrayAdapter.notifyDataSetChanged();

              }else
              {
                  Toast.makeText(Tramo.this, "No puede dejar campos vacíos", Toast.LENGTH_SHORT).show();

              }

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
                añadetramo();
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



    public void añadetramo(){
        Intent intent = new Intent(this,Tramo.class);
        startActivity(intent);
    }

    public void añadeposicion(){
        Intent intent = new Intent(this,Posicion.class);
        startActivity(intent);
    }


    public void irARuta(){
        if (list.isEmpty()){
            Toast.makeText(getApplicationContext(),"La lista está vacía",Toast.LENGTH_SHORT).show();
        }else {
            Intent intentR = new Intent(Tramo.this, Ruta.class);
            intentR.putStringArrayListExtra("key2", list);
            startActivity(intentR);
        }
    }

   public void cargarLV(){
        list= new ArrayList<String>();
        ArrayList<String> list = getIntent().getStringArrayListExtra("key2");
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }
}
