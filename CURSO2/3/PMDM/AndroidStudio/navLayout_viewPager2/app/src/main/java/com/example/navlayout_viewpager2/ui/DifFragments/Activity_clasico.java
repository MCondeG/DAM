package com.example.navlayout_viewpager2.ui.DifFragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navlayout_viewpager2.R;
import com.example.navlayout_viewpager2.databinding.ActivityMainBinding;
import com.example.navlayout_viewpager2.ui.fragment.ColorAzul_clasico;
import com.example.navlayout_viewpager2.ui.fragment.ColorRosa_clasico;
import com.example.navlayout_viewpager2.ui.fragment.ProfesorFragment;
import com.example.navlayout_viewpager2.ui.modelo.Profesor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Activity_clasico extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    boolean modo_rosa=false;
    static int numero=0;
    Fragment mn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_clasico);
        mn=new ColorAzul_clasico();
        loadFragment(mn,"azul");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment f = null;
                if (modo_rosa){
                    onClickButton();
                    replaceFragment(mn,"azul");
                    modo_rosa=false;
                }
                else {
                    mn= (ColorAzul_clasico)getSupportFragmentManager().findFragmentByTag("azul");
                    loadFragment(new ColorRosa_clasico(),"rosa");
                    modo_rosa=true;
                }
                //modo_rosa=!modo_rosa;


            }
        });

    }

    //Diferentes acciones a realizar con los Fragments

    private void loadFragment(Fragment f,String tag){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, f,tag)
                .commit();
    }
    private void replaceFragment(Fragment f,String tag){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor, f,tag)
                .commit();
    }
    private void replaceAddToBack(Fragment f){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor, f)
                .addToBackStack(null)
                .commit();
    }
    private void removeFragment(Fragment f){
        getSupportFragmentManager()
                .beginTransaction()
                .remove(f)
                .commit();
    }


    //Podemos gestionar un evento de click de botón a través de vinculación con XML
    public void pulsado(View view) {

        //se puede poner el evento en el fragment??
        //como hacer referencia al fragment y los widgets que en él hay??
        //Como saber si el fragment está activo??


        Button b= view.findViewById(R.id.buttonClasico);

        b.setText("adiós");



    }

    //Mediante la técnica de Interfaz propio capturamos otros eventos de un fragment
    public void onClickButton() {

        ColorAzul_clasico mn= (ColorAzul_clasico)getSupportFragmentManager().findFragmentByTag("azul");

        TextView tv=mn.getActivity().findViewById(R.id.textViewAzul);
        numero++;
        tv.setText(String.valueOf(numero));
        tv.setText(numero+"");


    }

}

