package com.example.examenada2.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.examenada2.ui.FragmentBlue;
import com.example.examenada2.ui.FragmentMain;
import com.example.examenada2.ui.FragmentRed;
import com.example.examenada2.ui.FragmentYellow;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentMain();
            case 1:
                return new FragmentBlue();
            case 2:
                return new FragmentRed();
            case 3:
                return new FragmentYellow();
        }
        return new FragmentMain();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
