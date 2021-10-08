package com.example.formulario1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText pass;
    private CheckBox cb;
    private RadioGroup rg;
    private Button b1;
    private Button b2;

    private Formulario form;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVariables();
        aceptar();
    }


    private void inicializaVariables() {

        this.nombre = (EditText) findViewById(R.id.editTextNombre);
        this.pass = (EditText) findViewById(R.id.editTextPass);
        this.cb = (CheckBox) findViewById(R.id.checkBox);
        this.rg = (RadioGroup) findViewById(R.id.radioGroup);
        this.b1 = (Button) findViewById(R.id.boton1);
        this.b2 = (Button) findViewById(R.id.boton2);
        this.form = new Formulario();
    }


    public void aceptar() {

        this.b1.setOnClickListener(
                view -> {
                    RadioButton rb = (RadioButton) findViewById(this.rg.getCheckedRadioButtonId());

                    this.form.setNombre(this.nombre.getText().toString());
                    this.form.setPass(this.pass.getText().toString());
                    this.form.setCb(this.cb.isChecked());
                    this.form.setRb(rb.getText().toString());

                    Toast.makeText(this, "Formulario enviado", Toast.LENGTH_LONG).show();
                }
        );
    }

    public void cancelar(View view) {

        this.nombre.setText("nombre");
        this.pass.setText("contraseña");
        this.cb.setChecked(false);
        this.rg.clearCheck();
    }
}