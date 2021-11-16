
package modelo;

import java.util.ArrayList;


public class Matricula {
    
    private Alumno a;
    private int id;
    private ArrayList<Taller> listaTalleres;

    public Alumno getAlumno() {
        return a;
    }

    public void setAlumno(Alumno a) {
        this.a = a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Taller> getListaTalleres() {
        return listaTalleres;
    }

    public void setListaTalleres(ArrayList<Taller> listaTalleres) {
        this.listaTalleres = listaTalleres;
    }
}
