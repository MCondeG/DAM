package com.example.rutas.Room.EntidadesRoom;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.rutas.Room.Constante;

@Entity(tableName=Constante.NOMBRE_TABLA_RUTA,
        foreignKeys=@ForeignKey(entity=TramoRoom.class,
                parentColumns="idtramo",
                childColumns = "idtramoF",
                onDelete=CASCADE))
public class RutaRoom {
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="idruta")
    private int idruta;

    @ColumnInfo(name="idtramoF")
    private int idtramo;


    @ColumnInfo(name="distancia_real")
    private Float distancia_real;

    @ColumnInfo(name="velocidad_real")
    private Float velocidad_real;

    @ColumnInfo(name="descripcion")
    private String descripcion;


    public RutaRoom() {
    }


    public RutaRoom(int idtramo, Float distancia_real, Float velocidad_real, String descripcion) {
        this.idtramo = idtramo;
        this.distancia_real = distancia_real;
        this.velocidad_real = velocidad_real;
        this.descripcion = descripcion;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public Float getDistancia_real() {
        return distancia_real;
    }

    public void setDistancia_real(Float distancia_real) {
        this.distancia_real = distancia_real;
    }

    public Float getVelocidad_real() {
        return velocidad_real;
    }

    public void setVelocidad_real(Float velocidad_real) {
        this.velocidad_real = velocidad_real;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdtramo() {
        return idtramo;
    }

    public void setIdtramo(int idtramo) {
        this.idtramo = idtramo;
    }

    @Override
    public String toString() {
        return "RutaRoom{" +
                "idruta=" + idruta +
                ", idtramo=" + idtramo +
                ", distancia_real=" + distancia_real +
                ", velocidad_real=" + velocidad_real +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}