package main.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import modelo.*;

public class MainActivity extends AppCompatActivity {

    private Modelo datos;
    private EditText etUser;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciaVariables();
    }


    private void iniciaVariables() {

        this.datos = new Modelo();
        this.etUser = (EditText)findViewById(R.id.editTextTextPersonName);
        this.etPass = (EditText)findViewById(R.id.editTextTextPassword);
    }

    public void pulsar(View v) {
        Toast.makeText(this, "Botón pulsado", Toast.LENGTH_SHORT).show();
    }

    public void verificar(View v) {

        Usuario p = new Usuario(this.etUser.getText().toString(), this.etPass.getText().toString());

        boolean verificado = this.datos.buscar(p);

        if(verificado) Toast.makeText(this, "Usuario verificado", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
    }

    public void borrar(View v) {

        this.etUser.setText("");
        this.etPass.setText("");
    }
}