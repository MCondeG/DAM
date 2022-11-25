package com.example.manuel_conde_gonzalez_examen1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;
    private EditText ed2;
    private double distancia;
    private double tiempo;
    private RadioGroup radio;
    private RadioButton unidades;
    private AlertDialog dialogo;

    private int seleccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ed1 = findViewById(R.id.distancia);
        this.ed2 = findViewById(R.id.tiempo);
        //this.distancia = Double.parseDouble(this.ed1.getText().toString());
        //this.tiempo = Double.parseDouble(this.ed2.getText().toString());
        this.radio = (RadioGroup) findViewById(R.id.radioGroup);
        this.unidades = null;
        this.dialogo = null;


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == 7) {
            double velocidad = data.getExtras().getDouble("velocidad");
            Toast.makeText(this,"velocidad = "+velocidad, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.toolbar_item1:
                this.dialogo = this.alertDialogConstructor().create();
                this.dialogo.show();
                break;
            case R.id.toolbar_item2:
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("distancia", this.distancia);
                intent.putExtra("tiempo", this.tiempo);
                startActivityForResult(intent,1234);
                break;
            case R.id.toolbar_item3:
                this.ed1.setText("");
                this.ed2.setText("");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }

        return true;
    }





    // Creación del alert dialog
    @NonNull
    private AlertDialog.Builder alertDialogConstructor() {

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_dialog, null);

        int seleccion;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Unidades");
        builder.setView(view);
        builder.setPositiveButton("OK", (dialog, id) -> {
            this.seleccion = radio.getCheckedRadioButtonId();
        });
        builder.setNegativeButton("Cancelar", (dialog, id) -> {
            dialog.cancel();
        });

        return builder;
    }
}