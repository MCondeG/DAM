package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import entidades.Alumno;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsar(View view) {
        Button boton= (Button)findViewById(R.id.button);
        String nombre=((EditText)findViewById(R.id.editText_nombre)).getText().toString();


        Intent intent=new Intent(this, ListViewPartes.class);
        String cadena="hola cómo estás?";
        int numero=8;
        intent.putExtra("mensaje",cadena);
        intent.putExtra("numero",numero);
        intent.putExtra("nombre",nombre);

        Alumno alumno=new Alumno("María");
        intent.putExtra("alumno",alumno);

        ArrayList<Alumno> alumnos=new ArrayList<>();
        alumnos.add(new Alumno("Pepe"));
        alumnos.add(new Alumno("Juán"));
        alumnos.add(new Alumno("Julia"));

        intent.putExtra("alumnos", alumnos);

        startActivity(intent);


        Toast.makeText(this,"boton pulsado",Toast.LENGTH_LONG).show();


    }


    public void marcar(View view) {

        switch(view.getId()){
            case R.id.checkBoxExpulsion:{

                Toast.makeText(this,"Expulsión",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.checkBoxGrave:{

                CheckBox chb =(CheckBox) findViewById(R.id.checkBoxExpulsion);
                chb.setChecked(true);

                Toast.makeText(this,"Parte grave",Toast.LENGTH_LONG).show();
                break;
            }

        }





    }

    public void onRadioButtonClicked(View view) {



    }


}