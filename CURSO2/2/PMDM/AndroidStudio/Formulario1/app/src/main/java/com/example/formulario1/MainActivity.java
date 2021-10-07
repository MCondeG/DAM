package com.example.formulario1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText pass;
    private CheckBox cb;
    private RadioGroup rg;
    private Button b1;
    private Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVariables();
    }


    private void inicializaVariables() {

        this.nombre = (EditText) findViewById(R.id.editTextNombre);
        this.pass = (EditText) findViewById(R.id.editTextPass);
        this.cb = (CheckBox) findViewById(R.id.checkBox);
        this.rg = (RadioGroup) findViewById(R.id.radioGroup);
        this.b1 = (Button) findViewById(R.id.boton1);
        this.b2 = (Button) findViewById(R.id.boton2);
    }


    public void aceptar(View view) {

    }

    public void cancelar(View view) {

        this.nombre.setText("nombre");
        this.pass.setText("contraseña");
        this.cb.setChecked(false);
        this.rg.clearCheck();
    }
}