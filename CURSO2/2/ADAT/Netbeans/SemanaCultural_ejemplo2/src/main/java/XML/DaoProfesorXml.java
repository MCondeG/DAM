package XML;

import modelo.Profesor;
import conexionJdbc.ConexionBD;
import java.util.ArrayList;

public class DaoProfesorXml {
    
    ConexionBD con = new ConexionBD("mysql", "semanaCultural", "root", "admin");
    private String fichero = "src/main/resources/staff.xml";
    private Parser parser;
    
   public void createProfesor(String fichero) throws Exception {
        parser = new Parser(fichero); 
        ArrayList<Profesor> lista = new ArrayList<Profesor>();
        lista = parser.procesarFichero();
        int id=lista.get(0).getId_profesor();
        String usuario=lista.get(0).getNombreUsuario();
        String password=lista.get(0).getPassword();
        String nombre=lista.get(0).getNombre();
        con.ejecutarInsert("insert into semanaCultural.profesor values ("+id+", '"+usuario+"','"+password+"','"+nombre+"');");
    }
}
