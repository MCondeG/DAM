package com.example.gestionrutas.modelo.colecciones;

import com.example.gestionrutas.modelo.entidades.Posicion;

import java.io.Serializable;
import java.util.ArrayList;


public class ListaPosiciones implements Serializable {

    private ArrayList<Posicion> listaPosiciones;


    public ListaPosiciones() {
        this.listaPosiciones = new ArrayList<Posicion>();
    }


    public ArrayList<Posicion> getListaPosiciones() {
        return listaPosiciones;
    }

    public void setListaPosiciones(ArrayList<Posicion> listaPosiciones) {
        this.listaPosiciones = listaPosiciones;
    }


    /*public int buscar() {

        this.listaPosiciones.stream().map(x->)

    }*/

    public void insertar(String nombre, String latitud, String longitud) {

        Posicion pos = new Posicion(nombre, Double.parseDouble(latitud), Double.parseDouble(longitud));
        this.listaPosiciones.add(pos);
    }

    public void eliminar(int id) {


    }
}