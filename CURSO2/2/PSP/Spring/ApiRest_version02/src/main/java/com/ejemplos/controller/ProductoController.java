package com.ejemplos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ejemplos.modelo.Producto;
import com.ejemplos.modelo.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor  //lombok crea el constructor
public class ProductoController {
	
	// se declara como final pq no se va a modificar este repositorio
	private final ProductoRepositorio productoRepositorio; 
	
	//se inyecta solo al crear el bean controlador
	//Dentro de la carpeta resources esta data.sql
	
	
	/**
	 * Obtenemos todos los productos
	 * 
	 * @return
	 */
	@GetMapping("/producto")
	public ResponseEntity<?> obtenerTodos() {
		
		List<Producto> result = productoRepositorio.findAll();
		
		if (result.isEmpty()) {
			// devolvemos una respuesta (404) como instancia de ResponseEntity
			return ResponseEntity.notFound().build();
		}
		else {
			// queremos devolver la lista, pero como en el if devolvemos una respuesta
			// 404 usando la clase ResponseEntity, debemos seguir usando la clase en la respuesta
			return ResponseEntity.ok(result);
		}
	}
	
	
	// Recoger dato
	//@PathVariable: permite inyectar un fragmento de la URL en una variable, es decir,
	//pasa el valor del id de la URL al método como parametro donde esté @PathVariable
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		
		Producto result = productoRepositorio.findById(id).orElse(null);
				
		if (result == null) return ResponseEntity.notFound().build();
		else return ResponseEntity.ok(result);
	}
	
	
	// Insertar dato
	//@RequestBody permite inyectar el cuerpo de la peticion en un objeto,
	//guardo en nuevo lo que venga del body en peticion
	@PostMapping("/producto")
	public ResponseEntity<?> nuevoProducto(@RequestBody Producto nuevo) {
		
		Producto saved = productoRepositorio.save(nuevo);
		// devuelve 201 cuando la inserción es exitosa
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	
	// Actualizar dato
	@PutMapping("/producto/{id}")
	public Producto editarProducto(@RequestBody Producto editar, @PathVariable Long id) {
		
		if (productoRepositorio.existsById(id)) {
			editar.setId(id);
			return productoRepositorio.save(editar);
		}
		else return null;
	}
	
	
	// Borrar dato
	@DeleteMapping("/producto/{id}")
	public Producto borrarProducto(@PathVariable Long id) {
		
		if (productoRepositorio.existsById(id)) {
			Producto result = productoRepositorio.findById(id).get();
			productoRepositorio.deleteById(id);
			return result;
		}
		else return null;
	}
}