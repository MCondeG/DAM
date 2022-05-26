package com.example.gestionrutas;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gestionrutas.modelo.colecciones.ListaGlobal;
import com.example.gestionrutas.modelo.entidades.Posicion;
import com.example.gestionrutas.vista.GpsFragment;
import com.example.gestionrutas.vista.MapsFragment;
import com.example.gestionrutas.vista.PosicionFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, PosicionFragment.OnListFragmentInteractionListener {


    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navView;
    private AlertDialog dialogo;

    //Base de datos estática
    private ListaGlobal datos = ListaGlobal.getGlobalData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializaVariables();

        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.drawerBuilder();
    }

    private void inicializaVariables() {

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navView = (NavigationView) findViewById(R.id.nav_view);
        this.dialogo = null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.toolbar_item1:
                this.dialogo = this.alertDialogConstructor(1).create();
                this.dialogo.show();
                break;
            case R.id.toolbar_item2:
                this.dialogo = this.alertDialogConstructor(2).create();
                this.dialogo.show();
                break;
            case R.id.toolbar_item3:
                Toast.makeText(this,"no implementado", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                this.drawer.openDrawer(GravityCompat.START);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }

        return true;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // Creación del alert dialog
    @NonNull
    private AlertDialog.Builder alertDialogConstructor(int caso) {

        LayoutInflater inflater = getLayoutInflater();
        View view = null;
        ArrayAdapter<Posicion> spinnerAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, datos.getPosiciones().getListaPosiciones());
        AlertDialog.Builder builder = null;

        switch (caso) {
            case 1:
                view = inflater.inflate(R.layout.formulario_posicion, null);

                EditText editText1 = (EditText) view.findViewById(R.id.editText1);
                EditText editText2 = (EditText) view.findViewById(R.id.editText2);
                EditText editText3 = (EditText) view.findViewById(R.id.editText3);

                builder = new AlertDialog.Builder(this);
                builder.setTitle("Añadir Posición")
                        .setView(view)
                        .setPositiveButton("OK", (dialog, id)->{
                            String nombre = editText1.getText().toString();
                            String latitud = editText2.getText().toString();
                            String longitud = editText3.getText().toString();

                            datos.getPosiciones().insertar(nombre, latitud, longitud);
                            spinnerAdapter.notifyDataSetChanged();

                            editText1.setText("");
                            editText2.setText("");
                            editText3.setText("");

                            Toast.makeText(this, "Posicion creada", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Cancelar", (dialog, id)->{dialog.cancel();});
                break;
            case 2:
                view = inflater.inflate(R.layout.formulario_tramo, null);

                Spinner spinner1 = view.findViewById(R.id.spinner1);
                Spinner spinner2 = view.findViewById(R.id.spinner2);

                spinner1.setAdapter(spinnerAdapter);
                spinner1.setOnItemSelectedListener(this);
                spinner2.setAdapter(spinnerAdapter);
                spinner2.setOnItemSelectedListener(this);

                builder = new AlertDialog.Builder(this);
                builder.setTitle("Añadir Tramo")
                        .setView(view)
                        .setPositiveButton("OK", (dialog, id)->{
                            Posicion pos1 = (Posicion) spinner1.getSelectedItem();
                            Posicion pos2 = (Posicion) spinner2.getSelectedItem();

                            datos.getTramos().insertar(pos1, pos2);

                            Toast.makeText(this, "Tramo creado", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Cancelar", (dialog, id)->{dialog.cancel();});

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + caso);
        }

        return builder;
    }


    private void drawerBuilder() {

        DrawerLayout drawerLayout = this.drawer;

        this.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.drawer_item1:
                                fragment = new PosicionFragment();
                                fragmentTransaction = true;
                                break;
                            case R.id.drawer_item2:
                                break;
                            case R.id.drawer_item3:
                                break;
                            case R.id.drawer_item4:
                                fragment = new GpsFragment();
                                fragmentTransaction = true;
                                break;
                            case R.id.drawer_item5:
                                fragment = new MapsFragment();
                                fragmentTransaction = true;
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                        }

                       if(fragmentTransaction) {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.contenedor, fragment)
                                    .commit();

                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }

                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }

    @Override
    public void onListFragmentInteraction(Posicion item) {
        Toast.makeText(this, item.getNombre(),Toast.LENGTH_LONG).show();
    }
}