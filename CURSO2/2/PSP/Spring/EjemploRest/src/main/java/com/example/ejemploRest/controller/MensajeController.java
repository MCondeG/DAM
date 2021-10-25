package com.example.ejemploRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemploRest.modelo.Mensaje;
import com.example.ejemploRest.modelo.MensajeJSON;
import com.example.ejemploRest.modelo.MensajeXML;

import lombok.NoArgsConstructor;


@RestController
@NoArgsConstructor
public class MensajeController {
	
	@GetMapping("/saludo")
	public String obtenerMensaje() {
		
		return new Mensaje("Hola Mundo!").toString();
	}
	
	
	@RequestMapping(value = "/saludo/xml", method = RequestMethod.GET, produces = "text/xml")
	public MensajeXML obtenerMensajeXML() {
		
		return new MensajeXML("Hola XML!");
	}
	
	
	@RequestMapping(value = "/saludo/json", method = RequestMethod.GET, produces = "application/json")
	public MensajeJSON obtenerMensajeJSON() {
		
		return new MensajeJSON("Hola JSON!");
	}
	
	
	@RequestMapping(value = "/saludo/json/{p}", method = RequestMethod.GET, produces = "application/json")
	public MensajeJSON obtenerMensajeJSON_2(@PathVariable String p) {
		
		return new MensajeJSON(p);
	}
}