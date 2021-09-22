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
public class Profesor {
 
    private int idProfesor;
    private String nombre;
    private String password;
    private String observaciones;
    
    private ArrayList<Parte> listaPartes;
    
    
    public Profesor() {
        this.listaPartes = new ArrayList<>();
    }

    public Profesor(int idProfesor, String nombre, String password, String observaciones, ArrayList<Parte> listaPartes) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.password = password;
        this.observaciones = observaciones;
        this.listaPartes = listaPartes;
    }

    
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ArrayList<Parte> getListaPartes() {
        return listaPartes;
    }

    public void setListaPartes(ArrayList<Parte> listaPartes) {
        this.listaPartes = listaPartes;
    }
}