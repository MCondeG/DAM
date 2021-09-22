package modelo.daos;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.entidades.Alumno;
import modelo.interfacesDaos.IDaoAlumno;

public class DaoAlumno extends Dao implements IDaoAlumno {


    public DaoAlumno() {

    }


    @Override
    public void addAlumno(Alumno alumno) {
        this.listaAlumnos.add(alumno);
    }

    @Override
    public boolean buscarAlumno(String nombre) {

        boolean b = false;

        Iterator<Alumno> it = creaIterador(this.listaAlumnos);

        while (it.hasNext()) {

            Alumno al = new Alumno();
            al = it.next();

            if (al.getNombre().equals(nombre)) b = true;
        }

        return b;
    }

    private static Iterator<Alumno> creaIterador(ArrayList<Alumno> listaAlumnos) {

        Iterator<Alumno> it = listaAlumnos.iterator();

        return it;
    }
}
