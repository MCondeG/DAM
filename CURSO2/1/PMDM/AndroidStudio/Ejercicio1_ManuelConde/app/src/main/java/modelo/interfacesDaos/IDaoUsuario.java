package modelo.interfacesDaos;

import modelo.entidades.Usuario;

public interface IDaoUsuario {

    public Usuario validarUsuario(String nombre, String contraseña);
}