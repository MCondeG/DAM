package com.example.examenRec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.roomdesdecero.R;
import com.example.examenRec.room.BaseDatos;
import com.example.examenRec.room.Cesta;
import com.example.examenRec.room.Producto;

public class MainActivity extends AppCompatActivity {
    private MenuItem itemAñadir;
    private Toolbar appbar;
    Fragment fragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(appbar);


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //BaseDatos.getBaseDatos(this).daoUsuario().borrarTabla();
        //BaseDatos.getBaseDatos(this).daoProducto().borrarTabla();
        //ArrayList<Producto> productos = null;

        Producto p=new Producto();
        p.setIdProducto(1);
        p.setNombrePro("Televisor");
        p.setPrecio(32);

        Producto p1= new Producto();
        p.setIdProducto(2);
        p.setNombrePro("pantalla");
        p.setPrecio(40);


        //Insertar productos
        BaseDatos.getBaseDatos(this).daoProducto().insertarProducto(p);
        BaseDatos.getBaseDatos(this).daoProducto().insertarProducto(p1);
        //BaseDatos.getBaseDatos(this).daoProducto().insertarProducto(p2);
        Log.d("BD",BaseDatos.getBaseDatos(this).daoProducto().getProductos().toString());
        //productos.add((Producto) BaseDatos.getBaseDatos(this).daoProducto().getProductos());

        //Borrar producto
        //BaseDatos.getBaseDatos(this).daoProducto().borrarProducto(p1);
        Log.d("BD",BaseDatos.getBaseDatos(this).daoProducto().getProductos().toString());

        //Insertar producto en la cesta
        Cesta c= new Cesta();
        c.setIdCesta(1);
        c.setIdProducto(2);
        BaseDatos.getBaseDatos(this).daoCesta().insertarCesta(c);
        Log.d("BD",BaseDatos.getBaseDatos(this).daoCesta().getcesta().toString());


        //Saber total de precio de una cesta
        int idPro=BaseDatos.getBaseDatos(this).daoCesta().getcesta().get(0).getIdProducto();
        Log.d("BD",BaseDatos.getBaseDatos(this).daoProducto().getPrecioProId(idPro)+"€");

        //BOrrar la cesta
        BaseDatos.getBaseDatos(this).daoCesta().borrarCesta(c);
        Log.d("BD",BaseDatos.getBaseDatos(this).daoCesta().getcesta().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        itemAñadir= menu.findItem(R.id.item_verP);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item_verP:
                Toast.makeText(getApplicationContext(),BaseDatos.getBaseDatos(this).daoProducto().getProductos().toString(),Toast.LENGTH_SHORT).show();
                //ProductoAdapter proAdap = new ProductoAdapter(FragProductos.listaproductos);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}