package com.example.pruebatoolbar_1.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pruebatoolbar_1.R;
import com.example.pruebatoolbar_1.db.ConexionBD;
import com.example.pruebatoolbar_1.db.ProfesorRepository;
import com.example.pruebatoolbar_1.db.entidades.Profesor;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_titulo);
        toolbar.setSubtitle(getString(R.string.ejemplo));

        toolbar.inflateMenu(R.menu.menu_toolbar);
        setSupportActionBar(toolbar);
     }

    @Override
    public boolean  onCreateOptionsMenu(Menu menu){

       // MenuInflater inflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;

    }


    //Manejo de eventos de toolbar

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_profesores:
                añadirProfesores();
                break;
            case R.id.ver_profesores:
                verProfesores();
                break;
        }
        return true;
    }


    private void verProfesores() {

      ProfesorRepository proRep= new ProfesorRepository(this);
      List<Profesor> profesores=proRep.verProfesores();




        String lista="";
        for(Profesor p:profesores){
            lista+=p.getNombre()+"\n";
        }


        Toast.makeText(this,lista, Toast.LENGTH_SHORT).show();


    }

    private void añadirProfesores() {

        Profesor p1=new Profesor ("Carmen");

         ProfesorRepository proRep= new ProfesorRepository(this);
         proRep.insertarProfesor(p1);





        Toast.makeText(this,"añadir profesores", Toast.LENGTH_SHORT).show();

    }



}
