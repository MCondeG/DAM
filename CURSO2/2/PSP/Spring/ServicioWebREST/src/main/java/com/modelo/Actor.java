package com.modelo;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Actor {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private String nacionalidad;
	
	@ManyToMany(mappedBy = "actores")
	private ArrayList<Pelicula> peliculas;
}