package com.example.gestionrutas.vista;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gestionrutas.R;
import com.example.gestionrutas.modelo.entidades.Posicion;
import com.example.gestionrutas.posicionamiento.Gps;


public class GpsFragment extends Fragment {

    private Gps gps;


    public GpsFragment() {
        this.gps = new Gps(getActivity());
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gps, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}