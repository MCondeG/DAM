
package Vista;

import modelo.Alumno;
import daoJdbc.DaoAlumnoJdbc;
import daoJdbc.DaoProfesorJdbc;
import modelo.Profesor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Opciones {
    
    DaoProfesorJdbc dP = new DaoProfesorJdbc();
    DaoAlumnoJdbc dA = new DaoAlumnoJdbc();
    List<Profesor> listaProfesor = new ArrayList<>();
    List<Alumno> listaAlumno = new ArrayList<>();
    
    public void consultaProfesor() {
        listaProfesor=dP.readProfesor();
        for (int i=0; i<listaProfesor.size(); i++) {
            System.out.println(listaProfesor.get(i).getNombre());
        }
    }
    
    public void consultaAlumnos() {
        listaAlumno=dA.readAlumno();
        for (int i=0; i<listaAlumno.size(); i++) {
            System.out.println("Nombre:"+ listaAlumno.get(i).getNombre());
            System.out.println("Usuario:"+ listaAlumno.get(i).getNombreUsuario());
            System.out.println("Contraseña:"+ listaAlumno.get(i).getPassword());
            System.out.println("ID Grupo:"+ listaAlumno.get(i).getId_grupo());
            System.out.println("ID Tutor:"+ listaAlumno.get(i).getId_alumno());
        }
    }
    
    public void crearProfesor(Scanner scId, Scanner scUs, Scanner scPa, Scanner scNo) {
        System.out.println("Inserta id");
        int id=scId.nextInt();
        System.out.println("Inserta nombre de usuario");
        String usuario=scUs.nextLine();
        System.out.println("Inserta contraseña");
        String password=scPa.nextLine();
        System.out.println(id+usuario+password);
        System.out.println("Inserta nombre");
        String nombre=scNo.nextLine();       
        dP.createProfesor(id, usuario, password, nombre);
    }
    
    public void crearAlumno(Scanner scId, Scanner scUs, Scanner scPa, Scanner scNo, Scanner scGr) {
        System.out.println("Inserta ID");
        int id=scId.nextInt();
        System.out.println("Inserta nombre de usuario");
        String usuario=scUs.nextLine();
        System.out.println("Inserta contraseña");
        String password=scPa.nextLine();
        System.out.println("Inserta nombre");
        String nombre=scNo.nextLine();          
        System.out.println("Inserta ID grupo");
        int grupo = scGr.nextInt();    
        dA.createAlumno(id, usuario, password, nombre, grupo);
    }
    
    public void eliminarProfesor(Scanner  scId) {
        System.out.println("Introduce ID a borrar");
        dP.deleteProfesor(scId.nextInt());
    }
    
    public void eliminarAlumno(Scanner scId) {
        System.out.println("Introduce ID a borrar");
        dA.deleteAlumno(scId.nextInt());
    }
    
    public void consultaProfesorPorId(Scanner scId) {
        Profesor p = new Profesor();
        System.out.println("Introduce ID del profesor");
        int idProf=scId.nextInt();
        p=dP.readForIdProfesor(idProf);
        System.out.println("ID: "+p.getId_profesor());
        System.out.println("Nombre: "+p.getNombre());
        System.out.println("Usuario: "+p.getNombreUsuario());
    }
    
    public void consultaAlumnoPorId(Scanner scId) {
        Alumno a = new Alumno();
        System.out.println("Introduce ID del alumno");
        int idAlum=scId.nextInt();
        a=dA.readForIdAlumno(idAlum);
        System.out.println("ID: "+a.getId_alumno());
        System.out.println("Nombre: "+a.getNombre());
        System.out.println("Usuario: "+a.getNombreUsuario());
        System.out.println("Grupo: "+a.getGrupo());
    }
}
