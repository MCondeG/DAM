package com.example.manuel_conde_gonzalez_examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    private double velocidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = this.getIntent().getExtras();

        double d = extras.getDouble("distancia");
        double t = extras.getDouble("tiempo");

        this.velocidad = d/t;
    }

    public void volver(View view) {

        Intent intent=new Intent();
        intent.putExtra("velocidad",this.velocidad);
        setResult(7,intent);
        finish();
    }
}