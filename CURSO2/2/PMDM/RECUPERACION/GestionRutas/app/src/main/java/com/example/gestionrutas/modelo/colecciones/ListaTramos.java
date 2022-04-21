package com.example.gestionrutas.modelo.colecciones;

import com.example.gestionrutas.modelo.Posicion;
import com.example.gestionrutas.modelo.Tramo;

import java.io.Serializable;
import java.util.ArrayList;


public class ListaTramos implements Serializable {

    private ArrayList<Tramo> listaTramos;


    public ListaTramos() {
        this.listaTramos = new ArrayList<Tramo>();
    }


    public ArrayList<Tramo> getListaTramos() {
        return listaTramos;
    }

    public void setListaTramos(ArrayList<Tramo> listaTramos) {
        this.listaTramos = listaTramos;
    }


    public void insertar(Posicion pos1, Posicion pos2) {

        Tramo tramo = new Tramo(pos1, pos2);
        this.listaTramos.add(tramo);
    }
}
