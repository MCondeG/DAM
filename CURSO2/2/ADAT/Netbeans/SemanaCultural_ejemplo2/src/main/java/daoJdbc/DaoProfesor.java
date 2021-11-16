
package daoJdbc;

import modelo.Profesor;
import java.util.List;


public interface DaoProfesor {
    
    public void createProfesor(int id_profesor, String nombreUsuario, String password, String nombre);
    public void deleteProfesor(int id);
    public void updateProfesor(int id, String password);
    public Profesor readForIdProfesor(int id);
    public List<Profesor> readProfesor();
    
    
}
