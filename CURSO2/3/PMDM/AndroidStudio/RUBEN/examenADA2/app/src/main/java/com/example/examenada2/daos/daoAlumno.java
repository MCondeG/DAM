package com.example.examenada2.daos;

import com.example.examenada2.models.Alumnos;

import java.util.ArrayList;

public class daoAlumno {

    private static ArrayList<Alumnos> alumnos = new ArrayList<>();;

    public daoAlumno(){
    }

    public static boolean addAlumno(Alumnos a){
        if (!alumnos.contains(a)){
            alumnos.add(a);
            return true;
        }
        return false;
    }

    public static ArrayList<Alumnos> getAlumnos(){
        return alumnos;
    }

    public static String showAlumnos() {
        String s = "";
        for (Alumnos a: alumnos){
            s += a.toString();
        }
        return s;
    }
    @Override
    public String toString() {
        String s = "";
        for (Alumnos a: alumnos){
            s += a.toString();
        }
        return s;
    }
}
