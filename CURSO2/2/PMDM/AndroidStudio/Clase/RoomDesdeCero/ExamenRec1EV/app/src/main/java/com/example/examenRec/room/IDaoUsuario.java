package com.example.examenRec.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IDaoUsuario {

    
    @Query("SELECT * FROM usuario WHERE nombreUsu LIKE :nombreUsu")
    Usuario getUsuarioNombre(String nombreUsu);
    @Query("SELECT * FROM usuario")
    public List<Usuario> getUsuarios();
    @Insert
    public void insertarUsuario(Usuario usuario);
    @Delete
    public void borrarUsuario(Usuario usuario);

    @Update
    public void editarUsuario(Usuario usuario);

    @Query("UPDATE usuario SET nombreUsu=:nombreNuevo WHERE nombreUsu=:nombreUsu")
    void actualizarUsuNombre(String nombreUsu,String nombreNuevo);

    @Query("DELETE FROM usuario")
    public void borrarTabla();

    @Query("DELETE FROM usuario WHERE nombreUsu LIKE :nombreUsu")
    void borrarUsuarioNombre(String nombreUsu);
}
