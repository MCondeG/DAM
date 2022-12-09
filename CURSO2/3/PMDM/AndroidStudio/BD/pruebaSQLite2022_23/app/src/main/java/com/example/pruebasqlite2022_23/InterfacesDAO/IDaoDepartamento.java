package com.example.pruebasqlite2022_23.InterfacesDAO;

import com.example.pruebasqlite2022_23.pojos.Departamento;

import java.util.ArrayList;

public interface IDaoDepartamento {

    public void crearDepartamento(Departamento dep);
    public void eliminarDepartamento(int id);
    public Departamento verDepartamento(int id);
    public ArrayList<Departamento> verDepartamentos();
    public void actualizarDepartamento (Departamento dep);


}
