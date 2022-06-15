/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rafa.spring.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rafa.spring.entidades.Ruta;

/**
 *
 * @author rafa
 */
public interface RutaRepository extends JpaRepository<Ruta,Integer>{
        
    @Query("select u from Ruta u" )
    public List<Ruta> verRutas();
    
    @Query("from Ruta u where u.idruta=?1")
    public Ruta verRuta(Integer id);
}
