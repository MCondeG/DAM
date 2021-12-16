package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerview.modelo.Profesor;


public class MainActivity extends AppCompatActivity implements ProfesorFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //La conexión del fragment con el activity está de forma estática

    }

    @Override
    public void onListFragmentInteraction(Profesor item) {
        Toast.makeText(this,item.getNombre(),Toast.LENGTH_LONG).show();
    }
}
