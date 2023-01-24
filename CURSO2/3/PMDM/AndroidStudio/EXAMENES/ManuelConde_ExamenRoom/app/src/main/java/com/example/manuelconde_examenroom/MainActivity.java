package com.example.manuelconde_examenroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.manuelconde_examenroom.modelo.entidades.Alumno;
import com.example.manuelconde_examenroom.modelo.entidades.AlumnoAsignatura_CrossRef;
import com.example.manuelconde_examenroom.modelo.entidades.Asignatura;
import com.example.manuelconde_examenroom.modelo.entidades.Grupo;
import com.example.manuelconde_examenroom.modelo.entidades.Profesor;
import com.example.manuelconde_examenroom.modelo.relaciones.Asignatura_Alumnos;
import com.example.manuelconde_examenroom.modelo.utils.AppDB;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Grupo grupo1 = new Grupo("grupo1", "1A");
        Grupo grupo2 = new Grupo("grupo2", "3B");

        Asignatura asignatura1 = new Asignatura("asignatura1");
        Asignatura asignatura2 = new Asignatura("asignatura2");
        Asignatura asignatura3 = new Asignatura("asignatura3");
        Asignatura asignatura4 = new Asignatura("asignatura4");
        Asignatura asignatura5 = new Asignatura("asignatura5");

        Profesor profesor1 = new Profesor("profesor1", "apellido1");
        Profesor profesor2 = new Profesor("profesor2", "apellido2");
        Profesor profesor3 = new Profesor("profesor3", "apellido3");

        Alumno alumno1 = new Alumno("alumno1", "apellido1");
        alumno1.setId_grupo(2);
        Alumno alumno2 = new Alumno("alumno2", "apellido2");
        alumno2.setId_grupo(1);
        Alumno alumno3 = new Alumno("alumno3", "apellido3");
        alumno3.setId_grupo(2);
        Alumno alumno4 = new Alumno("alumno4", "apellido4");
        alumno4.setId_grupo(1);
        Alumno alumno5 = new Alumno("alumno5", "apellido5");
        alumno5.setId_grupo(1);



        //creacion grupos
        AppDB.getAppDB(getApplicationContext()).daoGrupo().crearGrupo(grupo1);
        AppDB.getAppDB(getApplicationContext()).daoGrupo().crearGrupo(grupo2);


        //creacion asignaturas
        AppDB.getAppDB(getApplicationContext()).daoAsignatura().crearAsignatura(asignatura1);
        AppDB.getAppDB(getApplicationContext()).daoAsignatura().crearAsignatura(asignatura2);
        AppDB.getAppDB(getApplicationContext()).daoAsignatura().crearAsignatura(asignatura3);
        AppDB.getAppDB(getApplicationContext()).daoAsignatura().crearAsignatura(asignatura4);
        AppDB.getAppDB(getApplicationContext()).daoAsignatura().crearAsignatura(asignatura5);


        //creacion profesores
        AppDB.getAppDB(getApplicationContext()).daoProfesor().crearProfesor(profesor1);
        AppDB.getAppDB(getApplicationContext()).daoProfesor().crearProfesor(profesor2);
        AppDB.getAppDB(getApplicationContext()).daoProfesor().crearProfesor(profesor3);


        //creacion alumnos
        AppDB.getAppDB(getApplicationContext()).daoAlumno().crearAlumno(alumno1);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().crearAlumno(alumno2);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().crearAlumno(alumno3);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().crearAlumno(alumno4);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().crearAlumno(alumno5);


        //mostrar datos
        List<Grupo> grupos = AppDB.getAppDB(getApplicationContext()).daoGrupo().verGrupos();
        List<Asignatura> asignaturas = AppDB.getAppDB(getApplicationContext()).daoAsignatura().verAsignaturas();
        List<Profesor> profesores = AppDB.getAppDB(getApplicationContext()).daoProfesor().verProfesores();
        List<Alumno> alumnos = AppDB.getAppDB(getApplicationContext()).daoAlumno().verAlumnos();


        for (Grupo g: grupos) Log.d("EXAMEN - GRUPO", g.toString());

        for (Asignatura as: asignaturas) Log.d("EXAMEN - ASIGNATURA", as.toString());

        for(Profesor p: profesores) Log.d("EXAMEN - PROFESOR", p.toString());

        for (Alumno al: alumnos) Log.d("EXAMEN - ALUMNO", al.toString());


        //  PREGUNTA 3

        List<Alumno> alumnosGrupo = AppDB.getAppDB(getApplicationContext()).daoAlumno().verAlumnosGrupo(1);

        for (Alumno al: alumnosGrupo) Log.d("EXAMEN - ALUMNOS GRUPO 1", al.toString());


        //  PREGUNTA 4

        AlumnoAsignatura_CrossRef alas1 = new AlumnoAsignatura_CrossRef(1, 1);
        AlumnoAsignatura_CrossRef alas2 = new AlumnoAsignatura_CrossRef(1, 3);
        AlumnoAsignatura_CrossRef alas3 = new AlumnoAsignatura_CrossRef(1, 4);
        AlumnoAsignatura_CrossRef alas4 = new AlumnoAsignatura_CrossRef(2, 1);
        AlumnoAsignatura_CrossRef alas5 = new AlumnoAsignatura_CrossRef(2, 5);
        AlumnoAsignatura_CrossRef alas6 = new AlumnoAsignatura_CrossRef(5, 1);
        AlumnoAsignatura_CrossRef alas7 = new AlumnoAsignatura_CrossRef(5, 2);
        AlumnoAsignatura_CrossRef alas8 = new AlumnoAsignatura_CrossRef(5, 4);

        AppDB.getAppDB(getApplicationContext()).daoAlumno().matricularAsignatura(1, 1);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().matricularAsignatura(1, 3);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().matricularAsignatura(1, 4);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().matricularAsignatura(2, 1);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().matricularAsignatura(2, 5);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().matricularAsignatura(5, 1);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().matricularAsignatura(5, 2);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().matricularAsignatura(5, 4);


        List<Alumno> alumnosAsignatura = AppDB.getAppDB(getApplicationContext()).daoAsignatura().verAlumnosMatriculados(1);

        for (Alumno alas: alumnosAsignatura) Log.d("EXAMEN - ALUMNOS ASIGNATURA 1", alas.toString());
    }
}