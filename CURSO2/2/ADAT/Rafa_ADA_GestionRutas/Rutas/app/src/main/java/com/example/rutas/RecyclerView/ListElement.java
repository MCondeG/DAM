package com.example.rutas.RecyclerView;

public class ListElement {

    public String ruta;
    public String color;
    public String status;


    public ListElement(String ruta, String color, String status) {
        this.ruta = ruta;
        this.color = color;
        this.status = status;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
