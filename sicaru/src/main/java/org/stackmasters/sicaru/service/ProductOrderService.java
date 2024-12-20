package org.stackmasters.sicaru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stackmasters.sicaru.model.OrderEntity;
import org.stackmasters.sicaru.model.ProductEntity;
import org.stackmasters.sicaru.repository.OrderRepository;
import org.stackmasters.sicaru.repository.ProductRepository;

@Service
public class ProductOrderService {
	 @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderEntity addProductToOrder(Long pedidoId, Long productoId) {
        // Busca el pedido y el producto en la base de datos
        OrderEntity order = orderRepository.findById(pedidoId)
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        ProductEntity product = productRepository.findById(productoId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Añade el producto al pedido
        order.getProducts().add(product);

        // Guarda el pedido actualizado
        return orderRepository.save(order);
    }
}
