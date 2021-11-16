
package daoJpa;

import java.util.List;
import modeloJpa.*;


public interface DaoProfesor {
    
    public void crearProfesor(Profesor p);
    public void actualizarProfesor(Profesor p);
    public void borrarProfesor(Profesor p);
    public List<Profesor> verProfesores();
    public Profesor getProfesor(int idProfesor);
    public Profesor getProfesor(String nombre);
    public List<Taller> getTalleres(Profesor profesor);
    
}
