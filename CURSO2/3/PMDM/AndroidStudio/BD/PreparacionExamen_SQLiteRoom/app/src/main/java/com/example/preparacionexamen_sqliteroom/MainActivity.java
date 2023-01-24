package com.example.preparacionexamen_sqliteroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Alumno;
import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Asignatura;
import com.example.preparacionexamen_sqliteroom.modelo.room.entidades.Tutor;
import com.example.preparacionexamen_sqliteroom.modelo.room.utils.AppDB;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Tutor tutor1 = new Tutor("tutor1");
        Tutor tutor2 = new Tutor("tutor2");

        //crea tutores
        AppDB.getAppDB(getApplicationContext()).daoTutor().crearTutor(tutor1);
        AppDB.getAppDB(getApplicationContext()).daoTutor().crearTutor(tutor2);


        Alumno alumno1 = new Alumno("alumno1");
        alumno1.setId_tutor(2);
        Alumno alumno2 = new Alumno("alumno2");
        alumno2.setId_tutor(1);

        //crea alumnos
        AppDB.getAppDB(getApplicationContext()).daoAlumno().crearAlumno(alumno1);
        AppDB.getAppDB(getApplicationContext()).daoAlumno().crearAlumno(alumno2);


        Asignatura asignatura1 = new Asignatura("asignatura1", "curso1");
        Asignatura asignatura2 = new Asignatura("asignatura2", "curso2");
        Asignatura asignatura3 = new Asignatura("asignatura3", "curso1");

        //crea asignaturas
        AppDB.getAppDB(getApplicationContext()).daoAsignatura().crearAsignatura(asignatura1);
        AppDB.getAppDB(getApplicationContext()).daoAsignatura().crearAsignatura(asignatura2);
        AppDB.getAppDB(getApplicationContext()).daoAsignatura().crearAsignatura(asignatura3);


        //borra tutor 1 y actualiza alumnos relacionados
        //AppDB.getAppDB(getApplicationContext()).daoTutor().borrarTutor(AppDB.getAppDB(getApplicationContext()).daoTutor().verTutor(1));


        List<Tutor> tutores = AppDB.getAppDB(getApplicationContext()).daoTutor().verTutores();
        List<Alumno> alumnos = AppDB.getAppDB(getApplicationContext()).daoAlumno().verAlumnos();
        List<Asignatura> asignaturas = AppDB.getAppDB(getApplicationContext()).daoAsignatura().verAsignaturas();

        for (Tutor t: tutores) {
            Log.d("InstitutoDB - TUTOR", Integer.toString(t.getId_tutor()) + " - " + t.getNombre());
        }

        for (Alumno al: alumnos) {
            Log.d("InstitutoDB - ALUMNO", Integer.toString(al.getId_alumno()) + " - " + al.getNombre() + " - " + Integer.toString(al.getId_tutor()));
        }

        for (Asignatura as: asignaturas) {
            Log.d("InstitutoDB - ASIGNATURA", Integer.toString(as.getId_asignatura()) + " - " + as.getNombre() + " - " + as.getCurso());
        }
    }
}