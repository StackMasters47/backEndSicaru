package org.stackmasters.sicaru.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idOrder;
	
	@Column(name = "fecha_pedido", length = 100, nullable = false, unique = false)
	private LocalDateTime orderDate;
	
	@Column(name = "total", length = 100, nullable = false, unique = false)
	private Double total;
	
	@Column(name = "estado_pedido", length = 100, nullable = false, unique = false)
	private String orderState;
	
	/*
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	@JsonIgnore
	public UserEntity user;
*/
	
	public OrderEntity() {
		
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	
}
