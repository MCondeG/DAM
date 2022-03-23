package com.example.proyectogestionrutas.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaPosiciones implements Serializable {

    private ArrayList<Posicion> listaPosiciones;

    public ListaPosiciones() {
        this.listaPosiciones = new ArrayList<Posicion>();
    }
}
