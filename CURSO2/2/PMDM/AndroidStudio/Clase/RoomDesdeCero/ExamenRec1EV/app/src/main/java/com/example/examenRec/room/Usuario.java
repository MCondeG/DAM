package com.example.examenRec.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/*
@Entity(tableName="Usuario",
        foreignKeys ={
                @ForeignKey(entity = Producto.class,
                        parentColumns = "idProducto",
                        childColumns = "idProductoF")

        })*/
@Entity(tableName = "Usuario")
public class Usuario {
    @PrimaryKey
    @ColumnInfo(name="idUsuario")
    private int idUsuario;
    @ColumnInfo(name="nombreUsu")
    private String nombreUsu;

    @ColumnInfo(name="idProductoF")
    private int idProducto;
    public Usuario() {

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsu='" + nombreUsu + '\'' +
                ", idProducto=" + idProducto +
                '}';
    }
}
