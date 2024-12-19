package org.stackmasters.sicaru.org.service.dto;

import java.util.List;

public class OrderDTO {
	private Long id;
    private String date;
    private Double total;
    private String status;
    private Long user; 
    private List<Long> products;
    
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
