package org.stackmasters.sicaru.service.dto;

import java.util.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;


public class OrderDto {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long userId;

    @NotEmpty(message = "La lista de productos no puede estar vacía")
    private List<Long> productIds;

    @Positive(message = "El total debe ser mayor que cero")
    private Double total;

    // Getters y setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
