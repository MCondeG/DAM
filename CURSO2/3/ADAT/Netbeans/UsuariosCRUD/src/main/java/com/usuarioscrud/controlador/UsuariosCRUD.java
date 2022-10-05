package com.usuarioscrud.controlador;

import com.usuarioscrud.vista.Ventana;

/**
 *
 * @author manuelconde
 */
public class UsuariosCRUD {

    public static void main(String[] args) {
        
        Ventana ventana = new Ventana();
        Sql sql = new Sql();
        
        ventana.iniciar();
        
        sql.getConexion().abrirConexion();
    }
}
