package com.example.ejemploRest.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mensaje {
	
	private String mensaje;
	
	public Mensaje() {
		
		this.mensaje = "";
	}
	
	public Mensaje(String mensaje) {
		
		this.mensaje = mensaje;
	}
	
	
	@Override
	public String toString() {
		
		return this.getMensaje();
	}
}