package com.example.rutas.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rutas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PosicionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PosicionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "nombre";
    private static final String ARG_PARAM2 = "coordenada";

    // TODO: Rename and change types of parameters
    private String nombre;
    private String coordenada;

    public PosicionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param nombre Parameter 1.
     * @param coordenada Parameter 2.
     * @return A new instance of fragment PosicionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PosicionFragment newInstance(String nombre, String coordenada) {
        PosicionFragment fragment = new PosicionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nombre);
        args.putString(ARG_PARAM2, coordenada);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre = getArguments().getString(ARG_PARAM1);
            coordenada = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posicion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TextView)view.findViewById(R.id.tvnombre)).setText(nombre);
        ((TextView)view.findViewById(R.id.tvcoordenada)).setText(coordenada);
    }
}