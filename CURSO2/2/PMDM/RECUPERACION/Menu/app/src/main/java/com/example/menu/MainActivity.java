package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializaVariables();

        setSupportActionBar(toolbar);
    }


    private void inicializaVariables() {

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        /*switch(item.getItemId()){
            case R.id.item1:
                hacerMetodoItem1();
                break;
            case R.id.item2:
                hacerMetodoItem2();
                break;
        }*/
        return true;
    }
}