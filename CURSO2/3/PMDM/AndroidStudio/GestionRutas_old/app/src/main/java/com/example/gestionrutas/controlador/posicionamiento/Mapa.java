package com.example.gestionrutas.controlador.posicionamiento;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Mapa extends Thread {

    private OnMapReadyCallback callback;


    public Mapa() {

    }


    public OnMapReadyCallback getCallback() {
        return this.callback;
    }

    @Override
    public void run() {

        this.callback = new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng sevilla = new LatLng(37.4, -6);
                googleMap.addMarker(new MarkerOptions().position(sevilla).title("Sevilla"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(sevilla));
            }
        };
    }
}