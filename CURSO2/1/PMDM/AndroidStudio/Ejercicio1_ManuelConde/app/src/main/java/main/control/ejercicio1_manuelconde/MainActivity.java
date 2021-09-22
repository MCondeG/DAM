package main.control.ejercicio1_manuelconde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import modelo.daos.*;
import modelo.entidades.*;


public class MainActivity extends AppCompatActivity {

    private DaoUsuario datosUsuario;
    private EditText etUser;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicio();
    }


    private void inicio() {

        this.datosUsuario = new DaoUsuario();
        this.etUser = (EditText)findViewById(R.id.editTextTextPersonName);
        this.etPass = (EditText)findViewById(R.id.editTextTextPassword);
    }

    public void verificar(View v) {

        Usuario valid = datosUsuario.validarUsuario(this.etUser.getText().toString(), this.etPass.getText().toString());

        if(valid != null) {
            Toast.makeText(this, "Usuario verificado", Toast.LENGTH_SHORT).show();
            Intent int1 = new Intent(this, PantallaParte.class);
            startActivity(int1);
        }
        else {
            Toast.makeText(this, "ERROR. Usuario no válido", Toast.LENGTH_SHORT).show();
            borrar(this.etUser, this.etPass);
        }
    }

    public static void borrar(EditText etUser, EditText etPass) {

        etUser.setText("");
        etPass.setText("");
    }
}