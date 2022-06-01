package com.example.examenRec.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Producto")
public class Producto {
    @PrimaryKey
    @ColumnInfo(name="idProducto")
    private int idProducto;
    @ColumnInfo(name="nombrePro")
    private String nombrePro;
    @ColumnInfo(name="precio")
    private int precio;


    public Producto() {

    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombrePro='" + nombrePro + '\'' +
                ", precio=" + precio +
                '}';
    }
}
