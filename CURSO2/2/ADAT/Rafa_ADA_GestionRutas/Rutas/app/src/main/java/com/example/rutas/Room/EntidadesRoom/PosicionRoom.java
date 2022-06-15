package com.example.rutas.Room.EntidadesRoom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.rutas.Room.Constante;

@Entity(tableName= Constante.NOMBRE_TABLA_POSICION)
public class PosicionRoom {
    @PrimaryKey(autoGenerate=true)

    @ColumnInfo(name="idposicion")

    @NonNull   private int idposicion;

    @ColumnInfo(name="longitud")
    private Float longitud;

    @ColumnInfo(name="latitud")
    private Float latitud;

    @ColumnInfo(name="descripcion")
    private String descripcion;


    public PosicionRoom( Float longitud, Float latitud, String descripcion) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
    }

    public int getIdposicion() {
        return idposicion;
    }

    public void setIdposicion(int idposicion) {
        this.idposicion = idposicion;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "PosicionRoom{" +
                "idposicion=" + idposicion +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
