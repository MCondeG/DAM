package modelo.daos;

import modelo.entidades.Usuario;
import modelo.interfacesDaos.IDaoUsuario;

public class DaoUsuario extends Dao implements IDaoUsuario {


    public DaoUsuario() {
        super();
    }


    @Override
    public Usuario validarUsuario(String nombre, String contraseña) {

        for(Usuario usuario:listaUsuarios){
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }
}