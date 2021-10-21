package com.example.ejemploRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemploRest.modelo.Mensaje;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MensajeController {
	
	@GetMapping("/saludo")
	public String mostrarMensaje() {
		
		return new Mensaje("Hola Mundo").toString();
	}
}