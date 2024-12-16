
package org.stackmasters.sicaru.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stackmasters.sicaru.model.PedidosEntity;
import org.stackmasters.sicaru.repository.PedidosRepository;


@Service
public class PedidosService {
	
	private final PedidosRepository pedidosRepository;
	
	@Autowired
	public PedidosService(PedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
	}
	
	public List<PedidosEntity> getAll(){
		return this.pedidosRepository.findAll();
	}
	
	//Método para crear un nuevo Usuario
	public PedidosEntity createPedido(PedidosEntity newPedido) {
		return this.pedidosRepository.save(newPedido);
	}

}
