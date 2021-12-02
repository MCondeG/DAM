package com.modelo.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePeliculaDTO {
	
	private Long id;	
	private String nombre;
	private int año;
	private float duracion;
	private Long directorId;
	private List<Long> actorId;
}