package com.modelo;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Pelicula {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private int año;
	private float duracion;
	
	@ManyToOne
	@JoinColumn(name="director_id")
	private Director director;
	
	@JoinTable(
			name = "pelicula_actor",
			joinColumns = @JoinColumn(name = "pelicula_id"),
			inverseJoinColumns = @JoinColumn(name="director_id"))
	@ManyToMany
	private ArrayList<Actor> actores;
}