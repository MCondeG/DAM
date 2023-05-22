package com.example.gestionrutas.modelo.colecciones;

import com.example.gestionrutas.modelo.entidades.Ruta;

import java.io.Serializable;
import java.util.ArrayList;


public class ListaRutas implements Serializable {

    private ArrayList<Ruta> listaRutas;


    public ListaRutas() {
        this.listaRutas = new ArrayList<Ruta>();
    }


    public ArrayList<Ruta> getListaRutas() {
        return listaRutas;
    }

    public void setListaRutas(ArrayList<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
    }
}
