package daoJdbc;

import modelo.Alumno;
import java.util.List;

public interface DaoAlumno {
    
    public void createAlumno(int id_alumno, String nombreUsuario, String password, String nombre, int id_grupo);
    public void deleteAlumno(int id);
    public void updateAlumno(int id, String password);
    public Alumno readForIdAlumno(int id);
    public List<Alumno> readAlumno();
}
