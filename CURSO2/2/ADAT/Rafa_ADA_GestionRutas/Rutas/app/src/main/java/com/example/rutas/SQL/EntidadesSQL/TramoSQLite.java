package com.example.rutas.SQL.EntidadesSQL;

public class TramoSQLite {

    private int idtramo;
    private Float nodo_inicial;
    private Float nodo_final;
    private String descripcion;
    private int idposicionF;

    public TramoSQLite() {
    }

    public TramoSQLite(Float nodo_inicial, Float nodo_final, String descripcion,int idposicionF) {
        this.nodo_inicial = nodo_inicial;
        this.nodo_final = nodo_final;
        this.descripcion = descripcion;
        this.idposicionF = idposicionF;
    }

    public int getIdtramo() {
        return idtramo;
    }

    public void setIdtramo(int idtramo) {
        this.idtramo = idtramo;
    }

    public Float getNodo_inicial() {
        return nodo_inicial;
    }

    public void setNodo_inicial(Float nodo_inicial) {
        this.nodo_inicial = nodo_inicial;
    }

    public Float getNodo_final() {
        return nodo_final;
    }

    public void setNodo_final(Float nodo_final) {
        this.nodo_final = nodo_final;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdposicionF() {
        return idposicionF;
    }

    public void setIdposicionF(int idposicionF) {
        this.idposicionF = idposicionF;
    }

    @Override
    public String toString() {
        return "TramoSQLite{" +
                "idtramo=" + idtramo +
                ", nodo_inicial=" + nodo_inicial +
                ", nodo_final=" + nodo_final +
                ", descripcion='" + descripcion + '\'' +
                ", idposicionF=" + idposicionF +
                '}';
    }
}
