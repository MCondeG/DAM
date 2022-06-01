package com.example.examenRec.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName="Cesta",
        foreignKeys ={
                @ForeignKey(entity = Producto.class,
                        parentColumns = "idProducto",
                        childColumns = "idProductoF")

        })

public class Cesta {
    @PrimaryKey
    @ColumnInfo(name="idCesta")
    private int idCesta;

    @ColumnInfo(name="idProductoF")
    private int idProducto;


    public Cesta() {

    }

    public int getIdCesta() {
        return idCesta;
    }

    public void setIdCesta(int idCesta) {
        this.idCesta = idCesta;
    }


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }






    @Override
    public String toString() {
        return "Cesta{" +
                "idCesta=" + idCesta +
                ", idProducto=" + idProducto +
                '}';
    }
}
