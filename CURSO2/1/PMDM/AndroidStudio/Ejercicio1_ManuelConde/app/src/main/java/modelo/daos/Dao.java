package modelo.daos;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.entidades.*;

public class Dao implements Serializable {

    protected ArrayList<Usuario> listaUsuarios;
    protected ArrayList<Alumno> listaAlumnos;
    protected ArrayList<Parte> listaPartes;


    public Dao() {
        this.listaUsuarios = new ArrayList<> ();
        this.listaAlumnos = new ArrayList<>();
        this.listaPartes = new ArrayList<>();

        inicializaListaUsuarios(this.listaUsuarios);
        inicializaListaAlumnos(this.listaAlumnos);
    }


    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public ArrayList<Parte> getListaPartes() {
        return listaPartes;
    }

    public void setListaPartes(ArrayList<Parte> listaPartes) {
        this.listaPartes = listaPartes;
    }


    private static void inicializaListaUsuarios(ArrayList<Usuario> listaUsuarios) {

        for (int i = 0; i < 10; i++) {
            listaUsuarios.add(new Usuario());
        }

        listaUsuarios.add(new Usuario("enrique","enrique"));
        listaUsuarios.add(new Usuario("Enrique","Enrique"));
        listaUsuarios.add(new Usuario("Pedro","Pedro"));
        listaUsuarios.add(new Usuario("Adolfo","Adolfo"));
    }

    private static void inicializaListaAlumnos(ArrayList<Alumno> listaAlumnos) {

        listaAlumnos.add(new Alumno("Manuel"));
        listaAlumnos.add(new Alumno("Juan"));
        listaAlumnos.add(new Alumno("Carlos"));
        listaAlumnos.add(new Alumno("Raquel"));
        listaAlumnos.add(new Alumno("Enrique"));
        listaAlumnos.add(new Alumno("Dani"));
    }
}