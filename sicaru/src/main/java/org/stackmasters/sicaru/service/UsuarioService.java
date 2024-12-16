package org.stackmasters.sicaru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.stackmasters.sicaru.model.UsuarioEntity;
import org.stackmasters.sicaru.repository.UsuarioRepository;

public class UsuarioService {
	
private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<UsuarioEntity> getAll() {
		return this.usuarioRepository.findAll();
	}
	
	public UsuarioEntity crearUsuario(UsuarioEntity nuevoUsuario) {
		return this.usuarioRepository.save(nuevoUsuario);
	}
}
