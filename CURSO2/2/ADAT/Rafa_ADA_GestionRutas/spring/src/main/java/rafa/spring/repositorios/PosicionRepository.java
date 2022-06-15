/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rafa.spring.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rafa.spring.entidades.Posicion;

/**
 *
 * @author rafa
 */
public interface PosicionRepository extends JpaRepository<Posicion,Integer>{
    
      @Query("select u from Posicion u" )
    public List<Posicion> verPosiciones();
    
    @Query("from Posicion u where u.idposicion=?1")
    public Posicion verPosicion(Integer id);
}
