/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rafa.spring.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import rafa.spring.entidades.Tramo;
import rafa.spring.repositorios.TramoRepository;

/**
 *
 * @author rafa
 */
@Service
public class TramoService {
    private final TramoRepository tramoRepository;
    Tramo tramo;
    
     public TramoService(TramoRepository tramoRepository) {
        this.tramoRepository = tramoRepository;
    }
     
     
    public List<Tramo> listarTramos(){
 
        List<Tramo> tramos=tramoRepository.findAll();
          
        tramo = tramoRepository.verTramo(1);
       
        return tramos;
                  
    }
    
    
    public void guardarTramo(Tramo tramo){
        tramoRepository.save(tramo);
    }
}
