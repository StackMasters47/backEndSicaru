package org.stackmasters.sicaru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackmasters.sicaru.exceptions.UserNotFoundException;
import org.stackmasters.sicaru.model.UserEntity;
import org.stackmasters.sicaru.service.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//Endpoint para obtener usuarios
	@GetMapping("/users")
	public List<UserEntity> getUsers() {
		return this.userService.getAll();
	}
	
	//Endpoint para obtener un usuario por id
	@GetMapping("/users/{id}")
	public UserEntity findById(@PathVariable(name = "id") Long id) {
		return this.userService.userById(id);
	}
	
	//Endpoint para encontrar un usuario por su email
	@GetMapping("/users/email/{email}")
	public ResponseEntity<UserEntity> findByEmail(@PathVariable (name = "email") String email) {
			
		if (this.userService.findByEmail(email) == null) {
			return ResponseEntity.notFound().build();
		}
			
		return ResponseEntity.ok(this.userService.findByEmail(email));
	}
	
	//Endpoint para agregar un nuevo usuario
	@PostMapping("/new-user")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity newUser) {
		if (this.userService.findByEmail(newUser.getEmail()) != null ) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.addUser(newUser));
	}
	
	//Endpoint para actualizar un usuario 
	@PutMapping("/update-user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserEntity usuario, @PathVariable(name = "id") Long id) {
		try {
			return ResponseEntity.ok(this.userService.updateUser(usuario, id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Endpoint para eliminar un usuario por id
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable (name = "id") Long id) {
		this.userService.deleteUser(id);
	}

}
