/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rafa.spring.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import rafa.spring.entidades.Posicion;
import rafa.spring.repositorios.PosicionRepository;

/**
 *
 * @author rafa
 */
@Service
public class PosicionService {
    private final PosicionRepository posRepository;
    Posicion posicion;
    
    public PosicionService(PosicionRepository posRepository) {
        this.posRepository = posRepository;
    }
    
    
        public List<Posicion> listarPosiciones(){
        

        List<Posicion> posiciones=posRepository.findAll();
          
        posicion= posRepository.verPosicion(1);
       
        return posiciones;
                  
    }
        
         public void guardarPosicion(Posicion posicion){
        posRepository.save(posicion);
    }
}
