package com.example.navlayout_viewpager2.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navlayout_viewpager2.MainActivity;
import com.example.navlayout_viewpager2.R;
import com.example.navlayout_viewpager2.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Main_gallery  extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.main_galeria);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_1, R.id.nav_2, R.id.nav_3)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(navView, navController);

    }

    public void volver(View view){
            Intent intent = new Intent(this.getBaseContext(),
                    MainActivity.class);
            startActivity(intent);
        /*
         Fragment a = new Fragment (R.layout.fragment_gallery);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,a).addToBackStack(null)
                .commit();
        Button fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this.getBaseContext(),
                        GalleryFragment.class);
                startActivity(intent);
            }
        });
         */
    }
}
