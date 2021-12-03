package com.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modelo.Categoria;
import com.modelo.CategoriaRepositorio;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class CategoriaControlador {
	
	private final CategoriaRepositorio catRepo;
	
	@GetMapping("/categoria")
	public ResponseEntity<?> obtenerTodosDTO() {
		
		List<Categoria> result = catRepo.findAll();
		
		if (result.isEmpty()) return ResponseEntity.notFound().build();
		else return ResponseEntity.ok(result);
	}
}