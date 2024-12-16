package org.stackmasters.sicaru.controller;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/usuarios")
	public List<UsuarioEntity> getUsuarios() {
		return this.usuarioService.getAll();
	}
	
	@PostMapping("/usuario-nuevo")
	public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity nuevoUsuario) {
		return this.usuarioService.crearUsuario(nuevoUsuario);
	}
}
