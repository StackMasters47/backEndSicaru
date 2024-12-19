
package org.stackmasters.sicaru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackmasters.sicaru.model.OrderEntity;
import org.stackmasters.sicaru.org.service.dto.OrderDTO;
import org.stackmasters.sicaru.service.OrderService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class OrderController {
	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//Mapear el metodo getAll()
	@GetMapping("/orders")
	public List<OrderDTO> getOrder(){
		return this.orderService.getAll();
	}
	
	@PostMapping("/new-order")
	public OrderEntity createOrder(@RequestBody OrderDTO newOrderDTO) {
	    return this.orderService.createOrder(newOrderDTO);
	}
}
