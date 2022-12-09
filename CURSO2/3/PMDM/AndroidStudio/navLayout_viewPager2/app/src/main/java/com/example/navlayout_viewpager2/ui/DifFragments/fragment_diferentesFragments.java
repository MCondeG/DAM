package com.example.navlayout_viewpager2.ui.DifFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.navlayout_viewpager2.R;
import com.example.navlayout_viewpager2.ui.gallery.GalleryViewModel;

public class fragment_diferentesFragments extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.getActivity().recreate();
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root =inflater.inflate(R.layout.fragment_diferentes_fragments, container, false);
        Button b=root.findViewById(R.id.clasico);
        Button c=root.findViewById(R.id.eventos);
        Button d=root.findViewById(R.id.navegacion);
        b.setOnClickListener(v -> {
            b.setVisibility(View.VISIBLE);
            c.setVisibility(View.VISIBLE);
            d.setVisibility(View.VISIBLE);
            Intent intent = new Intent(this.getActivity().getBaseContext(),
                    Activity_clasico.class);
            startActivity(intent);
        });
        c.setOnClickListener(v -> {
            b.setVisibility(View.VISIBLE);
            c.setVisibility(View.VISIBLE);
            d.setVisibility(View.VISIBLE);
            Intent intent = new Intent(this.getActivity().getBaseContext(),
                    Activity_eventos.class);
            startActivity(intent);
        });
        d.setOnClickListener(v -> {
           // b.setVisibility(View.INVISIBLE);
           // c.setVisibility(View.INVISIBLE);
           // d.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(this.getActivity().getBaseContext(),
                    Activity_navegacion.class);
            startActivity(intent);
        });
        return root;
    }

}