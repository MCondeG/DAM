package com.ejemplos.controller;

import java.util.List;

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
	public List<Producto> obtenerTodos() {
		return productoRepositorio.findAll();
	}
	
	
	// Recoger dato
	//@PathVariable: permite inyectar un fragmento de la URL en una variable, es decir,
	//pasa el valor del id de la URL al método como parametro donde esté @PathVariable
	@GetMapping("/producto/{id}")
	public Producto obtenerUno(@PathVariable Long id) {
		return productoRepositorio.findById(id).orElse(null); //devuelve un Optional
		//no manejamos todavia los errores y devolvemos un null
	}
	
	
	// Insertar dato
	//@RequestBody permite inyectar el cuerpo de la peticion en un objeto,
	//guardo en nuevo lo que venga del body en peticion
	@PostMapping("/producto")
	public Producto nuevoProducto(@RequestBody Producto nuevo) {
		return productoRepositorio.save(nuevo);
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