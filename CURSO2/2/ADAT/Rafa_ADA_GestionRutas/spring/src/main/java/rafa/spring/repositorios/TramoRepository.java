/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rafa.spring.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rafa.spring.entidades.Tramo;




/**
 *
 * @author rafa
 */
public interface TramoRepository extends JpaRepository<Tramo,Integer>{
    
      @Query("select u from Tramo u" )
    public List<Tramo> verTramos();
    
    @Query("from Tramo u where u.idtramo=?1")
    public Tramo verTramo(Integer id);
    
}
