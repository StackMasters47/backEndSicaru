package org.stackmasters.sicaru.org.service.dto;

import java.util.List;

public class OrderCreateDTO {
	private Long user; // ID del usuario
    private List<Long> products; // Lista de IDs de productos

    // Getters y setters
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }
}
