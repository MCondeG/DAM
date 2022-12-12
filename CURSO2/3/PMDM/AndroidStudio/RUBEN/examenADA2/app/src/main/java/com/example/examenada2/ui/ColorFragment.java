package com.example.examenada2.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.examenada2.R;

public class ColorFragment extends Fragment {

    private View view;
    private String text;

    public ColorFragment() {
        // Required empty public constructor
    }

    public ColorFragment(String text) {
        this.text = text;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_color, container, false);
        updateText(text);
        return view;
    }

    public boolean updateText(String text){
        TextView colorText = view.findViewById(R.id.textColor);
        colorText.setText(text);
        return true;
    }


}