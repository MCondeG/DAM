package com.example.manuelconde_examenroom.modelo.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.manuelconde_examenroom.modelo.entidades.Alumno;
import com.example.manuelconde_examenroom.modelo.entidades.AlumnoAsignatura_CrossRef;
import com.example.manuelconde_examenroom.modelo.entidades.Asignatura;
import com.example.manuelconde_examenroom.modelo.relaciones.Asignatura_Alumnos;

import java.util.List;


@Dao
public interface IDaoAsignatura {

    //  CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void crearAsignatura(Asignatura asignatura);
    @Delete
    public void borrarAsignatura(Asignatura asignatura);
    @Update
    public void modificarAsignatura(Asignatura asignatura);
    @Query("SELECT * FROM asignatura WHERE id_asignatura LIKE :id_asignatura")
    public Asignatura verAsignatura(int id_asignatura);
    @Query("SELECT * FROM asignatura WHERE nombre LIKE :nombre")
    public Asignatura verAsignatura(String nombre);
    @Query("SELECT * FROM asignatura")
    public List<Asignatura> verAsignaturas();

    //  PREGUNTA 4
    @Transaction
    @Query("SELECT * FROM alumno, alumno_asignatura WHERE alumno_asignatura.id_asignatura LIKE :id_asignatura AND alumno_asignatura.id_alumno LIKE alumno.id_alumno")
    public List<Alumno> verAlumnosMatriculados(int id_asignatura);
}