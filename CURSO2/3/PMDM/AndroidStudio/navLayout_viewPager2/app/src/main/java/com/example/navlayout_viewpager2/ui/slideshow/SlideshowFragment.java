package com.example.navlayout_viewpager2.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.navlayout_viewpager2.databinding.FragmentSlideshowBinding;
import com.example.navlayout_viewpager2.ui.home.HomeFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private ViewPager2 viewPager2;
    private PageAdapter2 pageAdapter2;
    private TabLayout tabs;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.getActivity().recreate();
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        viewPager2= binding.viewPager2;
        pageAdapter2= new PageAdapter2(this.getActivity());
        viewPager2.setAdapter(pageAdapter2);


       tabs=binding.tabs;
        new TabLayoutMediator(tabs,viewPager2,(tab, position)->
        {if(position==0)tab.setText("panel1");
            if(position==1)tab.setText("panel2");}).attach();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}