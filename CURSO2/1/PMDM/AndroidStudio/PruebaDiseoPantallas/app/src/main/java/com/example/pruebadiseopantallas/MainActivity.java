package com.example.pruebadiseopantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void enviar(View view) {

        String texto=((TextView)findViewById(R.id.editText1)).getText().toString();
        Intent intent=new Intent(this, Activity2.class);
        intent.putExtra("texto", texto);
        //startActivity(intent);
          startActivityForResult(intent,1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Comprobamos si el resultado de la segunda actividad es "RESULT_CANCELED".
        if (resultCode == RESULT_CANCELED) {
            // Si es así mostramos mensaje de cancelado por pantalla.
            Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_SHORT).show();

        } else {
            // De lo contrario, recogemos el resultado de la segunda actividad.
            String resultado = data.getExtras().getString("valor_devuelto");
            Toast.makeText(this, ""+resultado, Toast.LENGTH_SHORT).show();

            ((TextView)findViewById(R.id.editText1)).setText(resultado);

        }
    }
}