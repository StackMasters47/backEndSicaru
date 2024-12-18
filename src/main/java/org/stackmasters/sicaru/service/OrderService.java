package org.stackmasters.sicaru.service;


import org.stackmasters.sicaru.model.OrderEntity;
import org.stackmasters.sicaru.repository.OrderRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Método para obtener todas las órdenes
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    // Método para obtener una orden por ID
    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Método para crear una nueva orden
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    // Método para actualizar una orden existente
    public Optional<OrderEntity> updateOrder(Long id, OrderEntity updatedOrder) {
        Optional<OrderEntity> orderOptional = orderRepository.findById(id);
        
        if (orderOptional.isPresent()) {
            OrderEntity existingOrder = orderOptional.get();
            existingOrder.setDate(updatedOrder.getDate());
            existingOrder.setTotal(updatedOrder.getTotal());
            existingOrder.setUser(updatedOrder.getUser());
            return Optional.of(orderRepository.save(existingOrder));
        }
        return Optional.empty();
    }

    // Método para eliminar una orden
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
