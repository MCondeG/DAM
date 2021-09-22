/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.util.ArrayList;

/**
 *
 * @author Ahbyss
 */
public class Incidencia {
    
    private int idIncidencia;
    private String tipo;
    
    private ArrayList<Parte> listaPartes;
    
    
    public Incidencia() {
        this.listaPartes = new ArrayList<>();
    }

    public Incidencia(int idIncidencia, String tipo, ArrayList<Parte> listaPartes) {
        this.idIncidencia = idIncidencia;
        this.tipo = tipo;
        this.listaPartes = listaPartes;
    }

    
    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Parte> getListaPartes() {
        return listaPartes;
    }

    public void setListaPartes(ArrayList<Parte> listaPartes) {
        this.listaPartes = listaPartes;
    }
}