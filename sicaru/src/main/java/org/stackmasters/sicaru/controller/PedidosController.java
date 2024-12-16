
package org.stackmasters.sicaru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackmasters.sicaru.model.PedidosEntity;
import org.stackmasters.sicaru.service.PedidosService;

@RestController
@RequestMapping("/api/v1")


public class PedidosController {
	private final PedidosService pedidosService;

	@Autowired
	public PedidosController(PedidosService pedidosService) {
		this.pedidosService = pedidosService;
	}
	
	//Mapear el metodo getAll()
	@GetMapping("/pedidos")
	public List<PedidosEntity> getPedidos(){
		return this.pedidosService.getAll();
	}
	
	@PostMapping("/new-pedido")
	public PedidosEntity createpedido(@RequestBody PedidosEntity newPedido) {
		return this.pedidosService.createProduct(newPedido);
	}
}
