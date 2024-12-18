package org.stackmasters.sicaru.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long id) {
		super("El usuario con id: " + id + "no fue encontrado");
	}
}
