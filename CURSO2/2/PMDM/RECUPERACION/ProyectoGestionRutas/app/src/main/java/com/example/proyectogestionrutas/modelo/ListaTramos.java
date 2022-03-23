package com.example.proyectogestionrutas.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaTramos implements Serializable {

    private ArrayList<Tramo> listaTramos;

    public ListaTramos() {
        this.listaTramos = new ArrayList<Tramo>();
    }
}
