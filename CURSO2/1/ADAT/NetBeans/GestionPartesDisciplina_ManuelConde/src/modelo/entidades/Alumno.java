/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Alumno {
    
    private int idAlumno;
    private String nombre;
    
    private ArrayList<Parte> listaPartes;

    
    public Alumno(){
        this.listaPartes = new ArrayList<>();
    }
    
    public Alumno(int idAlumno, String nombre) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.listaPartes = new ArrayList<>();
    }

    
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Parte> getListaPartes() {
        return listaPartes;
    }

    public void setListaPartes(ArrayList<Parte> listaPartes) {
        this.listaPartes = listaPartes;
    }
}