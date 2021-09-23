package com.example.pruebaempty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsar(View view) {

        etiqueta = (TextView) findViewById(R.id.textView1);
        etiqueta.setText("Adios");
    }
}