package com.example.examenada2.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.examenada2.R;

public class FragmentBlue extends Fragment {

    public FragmentBlue() {
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
        View view = inflater.inflate(R.layout.fragment_blue, container, false);
        Button button_purple = (Button)(view.findViewById(R.id.purple_btn));
        Button button_green = (Button)(view.findViewById(R.id.green_btn));

        button_purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewb) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentBlue_to_fragmentPurple);
            }
        });

        button_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewb) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentBlue_to_fragmentGreen);
            }
        });

        return view;
    }

}