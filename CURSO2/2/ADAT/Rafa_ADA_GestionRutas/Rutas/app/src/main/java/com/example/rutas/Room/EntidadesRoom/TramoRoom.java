package com.example.rutas.Room.EntidadesRoom;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.NO_ACTION;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.rutas.Room.Constante;

@Entity(tableName=Constante.NOMBRE_TABLA_TRAMO,
        foreignKeys=@ForeignKey(entity=PosicionRoom.class,
                parentColumns="idposicion",
                childColumns = "idposicionF",
                onDelete=CASCADE))
public class TramoRoom {
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="idtramo")
    private int idtramo;

    @ColumnInfo(name="idposicionF")
    private int idposicion;



    @ColumnInfo(name="nodo_inicial")
    private Float nodo_inicial;

    @ColumnInfo(name="nodo_final")
    private Float nodo_final;

    @ColumnInfo(name="descripcion")
    private String descripcion;


    public TramoRoom(int idposicion, Float nodo_inicial, Float nodo_final, String descripcion) {

        this.idposicion = idposicion;
        this.nodo_inicial = nodo_inicial;
        this.nodo_final = nodo_final;
        this.descripcion = descripcion;
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

    public int getIdposicion() {
        return idposicion;
    }

    public void setIdposicion(int idposicion) {
        this.idposicion = idposicion;
    }

    @Override
    public String toString() {
        return "TramoRoom{" +
                "idtramo=" + idtramo +
                ", idposicion=" + idposicion +
                ", nodo_inicial=" + nodo_inicial +
                ", nodo_final=" + nodo_final +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
