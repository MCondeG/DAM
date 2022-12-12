package com.example.examenada2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.examenada2.databinding.ActivityMainButtonsBinding;

public class MainActivityButtons extends AppCompatActivity {

    private ActivityMainButtonsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainButtonsBinding.inflate(getLayoutInflater());
        setSupportActionBar(binding.include.toolbar);
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.fragmentMain, R.id.fragmentBlue, R.id.fragmentRed, R.id.fragmentYellow, R.id.alumnosFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_buttons);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        return Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_buttons).navigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawer_layout_btn:
                Intent drawer = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(drawer);
                return true;
            case R.id.button_layout_btn:
                Intent botones = new Intent(getApplicationContext(), MainActivityButtons.class);
                startActivity(botones);
                return true;
            case R.id.tabbed_layout_btn:
                Intent tabulaciones = new Intent(getApplicationContext(), MainActivityTabbed.class);
                startActivity(tabulaciones);
                return true;
        }
        return false;
    }

}