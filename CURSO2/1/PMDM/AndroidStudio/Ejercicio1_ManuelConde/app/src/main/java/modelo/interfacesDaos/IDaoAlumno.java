package modelo.interfacesDaos;

import modelo.entidades.Alumno;

public interface IDaoAlumno {

    public void addAlumno(Alumno alumno);
    public boolean buscarAlumno(String nombre);
}
