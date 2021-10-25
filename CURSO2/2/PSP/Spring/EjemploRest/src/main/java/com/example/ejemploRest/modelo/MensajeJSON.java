package com.example.ejemploRest.modelo;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class MensajeJSON {
	
	private String mensaje;
	
	
	public MensajeJSON() {
		this.mensaje = "";
	}
	
	public MensajeJSON(String mensaje) {
		this.mensaje = mensaje;
	}
}