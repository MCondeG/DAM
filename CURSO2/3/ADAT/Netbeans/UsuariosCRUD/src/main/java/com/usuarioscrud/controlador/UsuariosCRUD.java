package com.usuarioscrud.controlador;

import com.usuarioscrud.vista.Ventana;

/**
 *
 * @author manuelconde
 */
public class UsuariosCRUD {

    public static void main(String[] args) {
        
        /* pruebas */
        
        Sql.añadir("nombre", "apellido", "direccion");
        Sql.añadir("nombre2", "apellido2", "direccion2");

        /* ------ */
        
        
        //Ventana ventana = new Ventana();
        
        //ventana.iniciar();
    }
}
