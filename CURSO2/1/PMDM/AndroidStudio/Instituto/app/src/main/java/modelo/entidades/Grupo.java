package modelo.entidades;

import java.util.ArrayList;

public class Grupo {

    private int idGrupo;
    private String nombre;

    private ArrayList<Alumno> listaAlumnos;


    public Grupo() {
        this.listaAlumnos = new ArrayList<>();
    }

    public Grupo(int idGrupo, String nombre, ArrayList<Alumno> listaAlumnos) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.listaAlumnos = listaAlumnos;
    }


    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
}