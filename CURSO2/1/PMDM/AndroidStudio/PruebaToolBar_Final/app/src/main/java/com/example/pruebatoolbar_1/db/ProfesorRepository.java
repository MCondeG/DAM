package com.example.pruebatoolbar_1.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.pruebatoolbar_1.db.daos.DaoProfesor;
import com.example.pruebatoolbar_1.db.entidades.Profesor;
import com.example.pruebatoolbar_1.ui.MainActivity;

import java.util.List;

public class ProfesorRepository {

    private DaoProfesor daoProfesor;

    public ProfesorRepository(MainActivity application) {

        ConexionBD bd =ConexionBD.getConexion(application);
        daoProfesor= bd.DaoProfesor();



    }

    public List<Profesor> verProfesores(){

        return daoProfesor.verProfesores();
    }

    public void insertarProfesor (Profesor profesor){
        new InsertarProfesorAsyncTask(daoProfesor).execute(profesor);
    }
    //Clase interna auxiliar para realizar la operación en segundo plano
    private static class InsertarProfesorAsyncTask extends AsyncTask<Profesor,Void, Void>{
        private DaoProfesor daoProfesor;

        InsertarProfesorAsyncTask(DaoProfesor daoProfesor){
            this.daoProfesor=daoProfesor;
        }
        @Override
        protected Void doInBackground(Profesor... profesors) {
            daoProfesor.insertarProfesor(profesors[0]);
            return null;
        }
    }
}
