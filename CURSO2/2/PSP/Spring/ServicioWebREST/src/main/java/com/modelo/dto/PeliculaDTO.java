package com.modelo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PeliculaDTO {
	
	private Long id;	
	private String nombre;
	private int año;
	private float duracion;
	private String directorNombre;
}