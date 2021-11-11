package com.example.manuelrafaelcondegonzalez_examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Ingredientes extends AppCompatActivity {

    private int calorias;

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;

    private Toolbar toolbar;

    private AlertDialog cantidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingredientes);

        inicializaVariables();
        construyeDialogo();

        setSupportActionBar(toolbar);
    }


    public void inicializaVariables() {

        this.calorias = 0;

        this.cb1 = (CheckBox) findViewById(R.id.cb1);
        this.cb2 = (CheckBox) findViewById(R.id.cb2);
        this.cb3 = (CheckBox) findViewById(R.id.cb3);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public boolean
    onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    public void construyeDialogo() {

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(view);
        builder.setTitle("Cantidad");
        builder.setPositiveButton("OK",(dialog, id)->{
            EditText et = (EditText) findViewById(R.id.editText);
        });
        builder.setNegativeButton("Cancelar",(dialog, id)->{
            dialog.cancel();
        });

        this.cantidad = builder.create();
    }

    public void click1(View v) {

        if (this.cb1.isChecked()) {
            this.cantidad.show();
        }
        else {

        }
    }

    public void click2(View v) {

        if (this.cb2.isChecked()) {
            this.cantidad.show();
        }
        else {

        }
    }

    public void click3(View v) {

        if (this.cb3.isChecked()) {
            this.cantidad.show();
        }
        else {

        }
    }
}