package com.example.examenada2.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenada2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRed extends Fragment {

    public FragmentRed() {
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
        return inflater.inflate(R.layout.fragment_red, container, false);
    }
}