/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rafa.spring.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rafa.spring.entidades.Posicion;
import rafa.spring.entidades.Ruta;
import rafa.spring.entidades.Tramo;
import rafa.spring.servicios.PosicionService;
import rafa.spring.servicios.RutaService;
import rafa.spring.servicios.TramoService;

/**
 *
 * @author rafa
 */
@Controller       
public class InicioController {
    
     private final PosicionService posService;
     private final TramoService tramoService;
     private final RutaService rutaService;
     
      public InicioController(PosicionService posService,TramoService tramoService,RutaService rutaService)
      {
          this.posService = posService; 
          this.tramoService= tramoService;
          this.rutaService = rutaService;
      }
    
      
      
        @RequestMapping("/")
    public String inicio(Model modelo){      
        return "inicio";
    }
      
      
      
      
      
    @RequestMapping("/listado_posiciones")
    public String listarposiciones(Model modelo){
        
        
        List<Posicion> posiciones =posService.listarPosiciones();
        modelo.addAttribute("posiciones", posiciones);
        
        
        return "listado_posiciones";
    }
    
    
    
    @RequestMapping("/listado_tramos")
    public String listartramos(Model modelo){
        
        
        List<Tramo> tramos =tramoService.listarTramos();
        modelo.addAttribute("tramos", tramos);
        
        
        return "listado_tramos";
    }
    
  
    @RequestMapping("/listado_rutas")
    public String listarrutas(Model modelo){
        
        
        List<Ruta> rutas =rutaService.listarRutas();
        modelo.addAttribute("rutas", rutas);
        
        
        return "listado_rutas";
    }
    
    
    @RequestMapping("/form_posicion")
    public String detallePosicion(Model modelo){
      Posicion pos=new Posicion();
      pos.setDescripcion("Posicion nueva aqui");
        
        //Si ya teniamos un usuario , tnedrá valores y se editará
        modelo.addAttribute("posicion",pos);  
        
        return"form_posicion";
    }
    
    
    @PostMapping("/guardarposicion")
    public String guardarPosicion(Posicion posicion){
        
       System.out.println(posicion.getDescripcion());
       posService.guardarPosicion(posicion);
        return"redirect:/";
    }
    
    
        @RequestMapping("/form_tramo")
    public String detalleTramo(Model modelo){
      Tramo tramo=new Tramo();
      
        modelo.addAttribute("tramo",tramo);  
        
        return"form_tramo";
    }
    
    
    @PostMapping("/guardartramo")
    public String guardarTramo(Tramo tramo){
        
       System.out.println(tramo.getNodoInicial());
       tramoService.guardarTramo(tramo);
        return"redirect:/";
    }
    
    
    
    
      @RequestMapping("/form_ruta")
    public String detalleRuta(Model modelo){
      Ruta ruta=new Ruta();
      ruta.setDescripcion("Ruta nueva aqui");
        
        
        modelo.addAttribute("ruta",ruta);  
        
        return"form_ruta";
    }
    
    
        @PostMapping("/guardaruta")
    public String guardarRuta(Ruta ruta){
        
       System.out.println(ruta.getDescripcion());
       rutaService.guardarRuta(ruta);
        return"redirect:/";
    }
    
}
