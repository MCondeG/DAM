package com.example.navlayout_viewpager2.ui.slideshow;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.navlayout_viewpager2.ui.fragment.Fragment1;
import com.example.navlayout_viewpager2.ui.fragment.Fragment2;

public class PageAdapter2 extends FragmentStateAdapter {
    public PageAdapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
