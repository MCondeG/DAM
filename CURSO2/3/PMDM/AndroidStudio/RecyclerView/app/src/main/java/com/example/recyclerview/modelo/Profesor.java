package com.example.recyclerview.modelo;

public class Profesor {


    private String urlFoto;
    private String nombre;
    private int horas_lectivas;
    private boolean mayor_55;

    public Profesor(String urlFoto, String nombre, int horas_lectivas, boolean mayor_55) {
        this.urlFoto = urlFoto;
        this.nombre = nombre;
        this.horas_lectivas = horas_lectivas;
        this.mayor_55 = mayor_55;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHoras_lectivas() {
        return horas_lectivas;
    }

    public boolean isMayor_55() {
        return mayor_55;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoras_lectivas(int horas_lectivas) {
        this.horas_lectivas = horas_lectivas;
    }

    public void setMayor_55(boolean mayor_55) {
        this.mayor_55 = mayor_55;
    }
}

