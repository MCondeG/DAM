package com.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modelo.Pelicula;
import com.modelo.PeliculaRepositorio;
import com.modelo.dto.CreatePeliculaDTO;
import com.modelo.dto.PeliculaDTO;
import com.modelo.dto.PeliculaDTOConverter;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class PeliculaController {

	private final PeliculaRepositorio peliculaRepo;
	
	private final PeliculaDTOConverter peliculaDTOConverter;
	
	
	
	@GetMapping("/pelicula")
	public ResponseEntity<?> obtenerTodosDTO() {
		
		List<Pelicula> result = peliculaRepo.findAll();
		
		if (result.isEmpty()) return ResponseEntity.notFound().build();
		else {
			List<PeliculaDTO> dtoList = result.stream().map(peliculaDTOConverter::convertirADTO).collect(Collectors.toList());
			
			return ResponseEntity.ok(dtoList);
		}
	}
	
	@PostMapping("/pelicula")
	public ResponseEntity<?> nuevoProducto(@RequestBody CreatePeliculaDTO nuevo) {
		
		Pelicula pelicula = peliculaDTOConverter.convertirAPelicula(nuevo);

		return ResponseEntity.status(HttpStatus.CREATED).body(peliculaRepo.save(pelicula));
	}
}