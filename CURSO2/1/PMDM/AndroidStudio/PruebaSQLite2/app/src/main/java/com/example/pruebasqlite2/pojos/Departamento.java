package com.example.pruebasqlite2.pojos;

public class Departamento {
    private int idDep;
    private String nombre;
    private String observaciones;

    public Departamento(){

    }

    public Departamento(String nombre) {

        this.nombre = nombre;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
