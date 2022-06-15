package com.example.rutas.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rutas.R;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends AppCompatActivity {

List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclycer);
        this.setTitle("Recycler");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

init();


    }//ONCREATE


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("Ruta 1","#000000","Activo"));
        elements.add(new ListElement("Ruta 2","#BA5454","No"));

       Adapter listAdapter =  new Adapter (elements, Recycler.this);
       RecyclerView recyclerView = findViewById(R.id.listRecyclewView);

       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(listAdapter);



    }
}
