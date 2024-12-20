package org.stackmasters.sicaru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stackmasters.sicaru.exceptions.UserNotFoundException;
import org.stackmasters.sicaru.model.UserEntity;
import org.stackmasters.sicaru.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//Método para obtener todos los usuarios
	public List<UserEntity> getAll() {
		return this.userRepository.findAll();
	}
	
	//Método para encontrar un usuario por su id
	public UserEntity userById(Long id) {
		return this.userRepository
				.findById(id)
				.orElseThrow (() -> new UserNotFoundException(id));
	}
	
	//Método para recuperar un usuario por email
	public UserEntity findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	//Método para agregar nuevos usuarios
	public UserEntity addUser(UserEntity newUser) {
		return this.userRepository.save(newUser);
	}
	
	//Método para actualizar los datos de un usuario
	public UserEntity updateUser(UserEntity user, Long id) {
		return this.userRepository.findById(id)
				.map(userField -> {
					userField.setName(user.getName());
					userField.setLastName(user.getLastName());
					userField.setEmail(user.getEmail());
					userField.setPassword(user.getPassword());
					return this.userRepository.save(userField);
				})
				.orElseThrow(() -> new UserNotFoundException(id));
	}
	
	//Método para eliminar un usuario por id
	public void deleteUser(Long id) {
		if (this.userRepository.existsById(id)) {
			this.userRepository.deleteById(id);
		} else {
			throw new UserNotFoundException(id);
		}
	}
	
}
