package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AlertDialog dialogo;


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
                break;
        }
        return true;
    }


    // Creación del alert dialog
    @NonNull
    private AlertDialog.Builder alertDialogConstructor() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Añadir Posición")
                .setPositiveButton("OK", (dialog, id)->{
                    Toast.makeText(this, "wqfwqf", Toast.LENGTH_SHORT).show();
                    //código de evento
                })
                .setNegativeButton("Cancelar", (dialog, id)->{dialog.cancel();});

        return builder;
    }
}