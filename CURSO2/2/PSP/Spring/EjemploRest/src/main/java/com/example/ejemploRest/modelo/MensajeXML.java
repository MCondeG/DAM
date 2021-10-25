package com.example.ejemploRest.modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "HolaMundo")
public class MensajeXML {
	
	private String mensaje;
	
	
	public MensajeXML() {
		this.mensaje = "";
	}
	
	public MensajeXML(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	@XmlElement(name = "saludo")
	public String getMensaje() {
		return this.mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}