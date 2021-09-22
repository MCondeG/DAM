package com.example.pruebatoolbar_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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
        Toast.makeText(this,"ver profesores", Toast.LENGTH_SHORT).show();
    }

    private void añadirProfesores() {
        Toast.makeText(this,"añadir profesores", Toast.LENGTH_SHORT).show();

    }



}
