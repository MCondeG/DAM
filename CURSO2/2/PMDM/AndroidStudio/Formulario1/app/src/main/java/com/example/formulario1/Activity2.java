package com.example.formulario1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class Activity2 extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        this.tv = (TextView) findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();
        ListaUsuarios lista = (ListaUsuarios) bundle.getSerializable("lista");

        for (int i = 0; i < lista.getLista().size(); i++) {

            Formulario form = lista.getLista().get(i);
            pintarDatos(form);
        }
    }


    public void pintarDatos(Formulario form) {

        this.tv.setText("\t\t\t\t\t\t\tDATOS\n\n");
        this.tv.append("\tUsuario: " + form.getNombre());
        this.tv.append("\n\tContraseña: ******");
        this.tv.append("\n\tProfesor: " + form.isCb());
        this.tv.append("\n\tCurso: " + form.getRb());
    }
}