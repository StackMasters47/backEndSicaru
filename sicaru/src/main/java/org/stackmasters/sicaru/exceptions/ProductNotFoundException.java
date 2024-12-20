package org.stackmasters.sicaru.exceptions;

public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(Long id) {
		super("El producto con id: " + id + "no existe.");
	}
}
