package com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Categoria {
	
	@Id @GeneratedValue
	private Long codigo;
	
	private String nombre;
	
	@Nullable
	private Byte estado;
}