package com.example.pruebadiseopantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Bundle extras=this.getIntent().getExtras();
       String texto=""+this.getRequestedOrientation();

       Toast.makeText(this, ""+texto,Toast.LENGTH_LONG).show();
       EditText editText=(EditText)findViewById(R.id.editText2);
       editText.setText(texto);






    }

    public void devolver(View view) {

        String resultado=((EditText)findViewById(R.id.editText2)).getText().toString();
        Intent intent=this.getIntent().putExtra("valor_devuelto",resultado);
        setResult(Activity.RESULT_OK,intent);
        finish();

    }
}