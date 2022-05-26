package com.example.gestionrutas.vista;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gestionrutas.R;
import com.example.gestionrutas.controlador.posicionamiento.Gps;


public class GpsFragment extends Fragment {

    private Gps gps;

    private TextView txtLatitud;
    private TextView txtLongitud;
    private TextView txtAltitud;
    private TextView txtSrc;
    private TextView txtDir;


    public GpsFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gps, container, false);

        this.gps = new Gps(getContext());

        this.txtLatitud = view.findViewById(R.id.txt_latitud);
        this.txtLongitud = view.findViewById(R.id.txt_longitud);
        this.txtAltitud = view.findViewById(R.id.txt_altitud);
        this.txtSrc = view.findViewById(R.id.txt_src);
        this.txtDir = view.findViewById(R.id.txt_dir);

        this.txtLatitud.setText(String.valueOf(this.gps.getLocation().getLatitude()));
        this.txtLongitud.setText(String.valueOf(this.gps.getLocation().getLongitude()));
        this.txtAltitud.setText(String.valueOf(this.gps.getLocation().getAltitude()));
        this.txtSrc.setText("Source: " + String.valueOf(this.gps.getProvider()));

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