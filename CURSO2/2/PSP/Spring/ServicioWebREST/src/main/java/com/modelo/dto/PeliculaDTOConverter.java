package com.modelo.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.modelo.Pelicula;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PeliculaDTOConverter {
	
	private final ModelMapper modelMapper;
	
	public PeliculaDTO convertirADTO(Pelicula pelicula) {
		return modelMapper.map(pelicula, PeliculaDTO.class);
	}
	
	public Pelicula convertirAPelicula(CreatePeliculaDTO createPeliculaDTO) {
		return modelMapper.map(createPeliculaDTO, Pelicula.class);
	}
}