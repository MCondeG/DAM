package modelo.entidades;

import java.util.ArrayList;

public class Alumno {

    private int idAlumno;
    private String nombre;

    private ArrayList<Parte> listaPartes;


    public Alumno(){
        this.listaPartes = new ArrayList<>();
    }

    public Alumno(int idAlumno, String nombre, ArrayList<Parte> listaPartes) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.listaPartes = listaPartes;
    }


    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Parte> getListaPartes() {
        return listaPartes;
    }

    public void setListaPartes(ArrayList<Parte> listaPartes) {
        this.listaPartes = listaPartes;
    }
}