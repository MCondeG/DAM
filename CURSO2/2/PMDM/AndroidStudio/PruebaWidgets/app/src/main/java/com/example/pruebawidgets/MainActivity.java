package com.example.pruebawidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculamos el widget a la variable
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoComplete_pais);

        //creamos un array con la lista definida en res/values/string.xml
        String[] countries = getResources().getStringArray(R.array.paises);

        //creamos un adaptador para dar formato al desplegable con las sugerencias de autocompletado
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        textView.setAdapter(adapter);

        //mostrar sugerencias a partir de 2 letras
        textView.setThreshold(2);
    }
}