package com.example.examenada2.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenada2.R;

public class AlumnosFragment extends Fragment {

    public AlumnosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_alumnos, container, false);

        view.findViewById(R.id.anadir_alumnos_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewb) {
                Navigation.findNavController(view).navigate(R.id.action_alumnosFragment_to_addAlumnoFragment);
            }
        });

        view.findViewById(R.id.ver_alumnos_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewb) {
                Navigation.findNavController(view).navigate(R.id.action_alumnosFragment_to_verAlumnosFragment);
            }
        });

        return view;
    }
}