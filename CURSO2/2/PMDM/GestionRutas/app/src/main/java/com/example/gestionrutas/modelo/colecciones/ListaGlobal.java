package com.example.gestionrutas.modelo.colecciones;


public class ListaGlobal {

    private ListaPosiciones posiciones;
    private ListaTramos tramos;
    private ListaRutas rutas;

    private static ListaGlobal globalData = new ListaGlobal();   //instancia única de clase singleton


    private ListaGlobal() {
        this.posiciones = new ListaPosiciones();
        this.tramos = new ListaTramos();
        this.rutas = new ListaRutas();
    }


    public ListaPosiciones getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ListaPosiciones posiciones) {
        this.posiciones = posiciones;
    }

    public ListaTramos getTramos() {
        return tramos;
    }

    public void setTramos(ListaTramos tramos) {
        this.tramos = tramos;
    }

    public ListaRutas getRutas() {
        return rutas;
    }

    public void setRutas(ListaRutas rutas) {
        this.rutas = rutas;
    }

    public static ListaGlobal getGlobalData() {
        return globalData;
    }

    public static void setGlobalData(ListaGlobal globalData) {
        ListaGlobal.globalData = globalData;
    }
}