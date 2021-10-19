package com.ejemplos.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(Long id) {
		super("No existe el producto con la ID: "+id);
	}
}