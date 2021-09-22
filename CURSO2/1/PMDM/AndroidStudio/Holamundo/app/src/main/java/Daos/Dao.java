package Daos;

import java.util.ArrayList;

import entidades.Alumno;
import entidades.Parte;
import entidades.Usuario;

public class Dao {

     ArrayList<Usuario> usuarios=new ArrayList<>();
     ArrayList<Alumno> alumnos;
     ArrayList<Parte> partes=new ArrayList<>();

     public Dao(){
         usuarios.add(new Usuario("enrique","enrique"));
         usuarios.add(new Usuario("Pedro","Pedro"));
         usuarios.add(new Usuario("Adolfo","Adolfo"));

     };


}
