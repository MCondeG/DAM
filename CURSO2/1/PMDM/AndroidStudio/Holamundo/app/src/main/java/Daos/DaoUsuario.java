package Daos;

import entidades.Usuario;
import interfacesDaos.interfaceDaoUsuario;

public class DaoUsuario extends Dao implements interfaceDaoUsuario {

    @Override
    public Usuario validarUsuario(String nombre, String password) {

        for(Usuario usuario:usuarios){
            if (usuario.getNombre().equals(nombre) &&
                    usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }




}
