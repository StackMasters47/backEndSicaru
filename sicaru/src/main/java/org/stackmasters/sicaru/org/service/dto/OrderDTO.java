package org.stackmasters.sicaru.org.service.dto;

import java.util.List;

import org.stackmasters.sicaru.model.UserEntity;

public class OrderDTO {
	private Long id;
    private String date;
    private Double total;
    private String status;
    private UserEntity user; // Usamos directamente UserEntity
    private List<ProductDTO> products; // Nueva clase DTO para productos
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
    
}
