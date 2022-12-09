package com.example.navlayout_viewpager2.ui.fragment;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.navlayout_viewpager2.R;

public class fragment_3_navegacion extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_3_navegacion, container, false);
        Button boton1=root.findViewById(R.id.button3);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                findNavController(view).navigate(R.id.action_fragment_3_navegacion_to_fragment_1_navegacion2);
            }
        });
        return root;
    }
}