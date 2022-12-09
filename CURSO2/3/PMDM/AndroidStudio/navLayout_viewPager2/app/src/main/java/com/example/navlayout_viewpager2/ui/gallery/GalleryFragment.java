package com.example.navlayout_viewpager2.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.navlayout_viewpager2.databinding.FragmentGalleryBinding;
import com.example.navlayout_viewpager2.ui.home.HomeFragment;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private ViewPager2 viewPager2;
    private PageAdapter2 pageAdapter2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.getActivity().recreate();
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button b=binding.button;
        b.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity().getBaseContext(),
                    Main_gallery.class);
            startActivity(intent);
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        //finish();
        //startActivity(getIntent());
    }

}