/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rafa.spring.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import rafa.spring.entidades.Ruta;
import rafa.spring.repositorios.RutaRepository;


/**
 *
 * @author rafa
 */

@Service
public class RutaService {
     private final RutaRepository rutaRepository;
    Ruta ruta;
    
    public RutaService(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }
    
    
        public List<Ruta> listarRutas(){
        List<Ruta> rutas=rutaRepository.findAll(); 
        ruta= rutaRepository.verRuta(1);
       
        return rutas;                  
    }
        
        
        public void guardarRuta(Ruta ruta){
        rutaRepository.save(ruta);
    }
}
