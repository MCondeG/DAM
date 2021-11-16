
package Vista;

import java.util.Scanner;

public class Vista {
    public static void main(String[] args) {
        
        Opciones op = new Opciones();
        
        Scanner scOpcion = new Scanner(System.in);
        Scanner sc1= new Scanner(System.in);
        Scanner sc2= new Scanner(System.in);
        Scanner sc3= new Scanner(System.in);
        Scanner sc4= new Scanner(System.in);
        Scanner sc5= new Scanner(System.in);
        
        System.out.println("Elige opción");
        System.out.println("1. Ver profesores");
        System.out.println("2. Ver alumnos");
        System.out.println("3. Insertar profesor");
        System.out.println("4. Insertar alumno");
        System.out.println("5. Eliminar profesor");
        System.out.println("6. Eliminar alumno");
        System.out.println("7. Consultar profesor por ID");
        System.out.println("8. Consultar alumno por ID");
        
        int opcion = scOpcion.nextInt();
        
        switch (opcion) {
            case 1:
                op.consultaProfesor();
                break;
            case 2:
                op.consultaAlumnos();
                break;
            case 3:
                op.crearProfesor(sc1, sc2, sc3, sc4);
                break;
            case 4:
                op.crearAlumno(sc1, sc2, sc3, sc4, sc5);
                break;
            case 5:
                op.eliminarProfesor(sc1);
                break;
            case 6:
                op.eliminarAlumno(sc1);
                break;
            case 7:
                op.consultaProfesorPorId(sc1);
                break;
            case 8:
                op.consultaAlumnoPorId(sc1);
                break;
        } 
    }
}
