package com.example.navlayout_viewpager2.ui.DifFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.navlayout_viewpager2.R;

public class Activity_eventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_eventos);
        Button boton=findViewById(R.id.button5);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pulsar("hola");
            }
        });


    }

    public void pulsar(String texto){
        Toast.makeText(this,texto,Toast.LENGTH_LONG).show();
    }
    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
           // listener = (OnClickBoton) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " Se debe implementar OnClickBotonDia");
        }
    }*/

}