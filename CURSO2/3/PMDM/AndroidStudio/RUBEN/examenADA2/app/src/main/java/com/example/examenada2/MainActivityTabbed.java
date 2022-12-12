package com.example.examenada2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.examenada2.adapters.MyViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.examenada2.databinding.ActivityMainTabbedBinding;

public class MainActivityTabbed extends AppCompatActivity {

    private ActivityMainTabbedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar2);

        MyViewPagerAdapter pagerAdapter = new MyViewPagerAdapter(this);
        ViewPager2 viewPager2 = binding.viewPager;
        viewPager2.setAdapter(pagerAdapter);
        TabLayout tabs = binding.tabs;

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabs.getTabAt(position).select();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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