package org.stackmasters.sicaru.controller;

import org.stackmasters.sicaru.model.OrderEntity;
import org.stackmasters.sicaru.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")  // URL base para las órdenes
public class OrderController {

    private final OrderService orderService;

    // Inyección de dependencias del servicio OrderService
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Método para obtener todas las órdenes
    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();  // Si no hay órdenes, retornamos 204 No Content
        }
        return ResponseEntity.ok(orders);  // Si hay órdenes, retornamos 200 OK con la lista de órdenes
    }

    // Método para obtener una orden específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long id) {
        Optional<OrderEntity> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)  // Si la orden existe, retornamos 200 OK con la orden
                    .orElseGet(() -> ResponseEntity.notFound().build());  // Si no existe, retornamos 404 Not Found
    }

    // Método para crear una nueva orden
    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        OrderEntity createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);  // Retorna 201 Created
    }

    // Método para actualizar una orden existente
    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity updatedOrder) {
        Optional<OrderEntity> order = orderService.updateOrder(id, updatedOrder);
        return order.map(ResponseEntity::ok)  // Si la orden se actualiza correctamente, retornamos 200 OK con la orden actualizada
                    .orElseGet(() -> ResponseEntity.notFound().build());  // Si no se encuentra la orden, retornamos 404 Not Found
    }

    // Método para eliminar una orden por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();  // Retorna 204 No Content cuando la eliminación es exitosa
    }
}
