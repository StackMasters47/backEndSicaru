
package org.stackmasters.sicaru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stackmasters.sicaru.model.OrderEntity;
import org.stackmasters.sicaru.model.ProductEntity;
import org.stackmasters.sicaru.model.UserEntity;
import org.stackmasters.sicaru.org.service.dto.OrderDTO;
import org.stackmasters.sicaru.repository.OrderRepository;
import org.stackmasters.sicaru.repository.ProductRepository;
import org.stackmasters.sicaru.repository.UserRepository;



@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
    private final UserRepository userRepository;

	
	@Autowired
	public OrderService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
        this.userRepository = userRepository;
	}
	
	//Método para obtener todos los pedidos
	public List<OrderDTO> getAll(){
		// Obtener las órdenes completas desde el repositorio
	    List<OrderEntity> orders = this.orderRepository.findAll();
	    
	    // Convertir las órdenes a DTOs
	    List<OrderDTO> orderDTOs = orders.stream().map(order -> {
	        OrderDTO orderDTO = new OrderDTO();
	        orderDTO.setId(order.getId());
	        orderDTO.setDate(order.getDate());
	        orderDTO.setTotal(order.getTotal());
	        orderDTO.setStatus(order.getStatus());
	        
	        // Solo almaceno el ID del usuario
	        orderDTO.setUser(order.getUser().getId());

	        // Solo almaceno los IDs de los productos
	        List<Long> productIds = order.getProducts().stream()
	            .map(product -> product.getId())
	            .collect(Collectors.toList());
	        orderDTO.setProducts(productIds);
	        
	        return orderDTO;
	    }).collect(Collectors.toList()); //Añadimos todos los DTO en una lista.
	    
	    return orderDTOs;
	}
	
	//Método para crear un pedido
	public OrderEntity createOrder(OrderDTO newOrderDTO) {
        OrderEntity order = new OrderEntity();

        // Establecer fecha, total, estado (por ejemplo, Pendiente)
        order.setDate(newOrderDTO.getDate());
        order.setTotal(newOrderDTO.getTotal());
        order.setStatus(newOrderDTO.getStatus());

        // Establecer el usuario
        UserEntity user = userRepository.findById(newOrderDTO.getUser()).orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);

        // Establecer los productos
        List<ProductEntity> products = productRepository.findAllById(newOrderDTO.getProducts());
        order.setProducts(products);

        // Guardar la orden
        return orderRepository.save(order);
    }

}
