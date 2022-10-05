package com.example.formulariousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.formulariousuario.modelo.Modelo;


public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nombre = findViewById(R.id.nombre);
        this.apellido = findViewById(R.id.apellido);
    }


    public void aceptar(View view) {

        Modelo.añadir(this.nombre.getText().toString(), this.nombre.getText().toString());

        Intent intent = new Intent(this, Activity2.class);
        startActivityForResult(intent,1234);
    }

    public void cancelar(View view) {

    }

    public void ver(View view) {

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == 7) {
            String mensaje = data.getExtras().getString("valor");
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }
}