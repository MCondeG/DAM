package com.example.formulario1;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaUsuarios implements Serializable {

    private ArrayList<Formulario> lista;


    public ListaUsuarios () {
        this.lista = new ArrayList<>();
    }


    public ArrayList<Formulario> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Formulario> lista) {
        this.lista = lista;
    }


    public void añadir(Formulario form) {

        this.lista.add(form);
    }
}