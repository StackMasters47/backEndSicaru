package org.stackmasters.sicaru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackmasters.sicaru.model.OrderEntity;
import org.stackmasters.sicaru.service.ProductOrderService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ProductOrderController {
	@Autowired
    private ProductOrderService productOrderService;

    @PostMapping("order/{pedidoId}/product/{productoId}")
    public ResponseEntity<OrderEntity> addProductoToPedido(
        @PathVariable Long pedidoId,
        @PathVariable Long productoId
    ) {
        OrderEntity order = productOrderService.addProductToOrder(pedidoId, productoId);
        return ResponseEntity.ok(order);
    }
}
