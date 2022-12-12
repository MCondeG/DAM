package com.example.examenada2.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenada2.R;

public class FragmentYellow extends Fragment {

    public FragmentYellow() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yellow, container, false);
        view.findViewById(R.id.orange_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewb) {
                Fragment orangeFragment = new OrangeFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmenrContainerForOrange, orangeFragment);
                transaction.commit();
            }
        });

        view.findViewById(R.id.color_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewb) {
                EditText text = (EditText)(view.findViewById(R.id.editTextColor));
                FragmentContainerView fcv = view.findViewById(R.id.fragmentContainerForColor);
                ColorFragment cf = fcv.getFragment();
                cf.updateText(text.getText().toString());
            }
        });
        return view;
    }
}