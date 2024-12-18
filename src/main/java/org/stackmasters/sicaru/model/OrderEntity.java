package org.stackmasters.sicaru.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private Long idOrder;
	
	@Column(name = "date", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime date;
	
	@Column(name = "total", nullable = false, columnDefinition = "DECIMAL(7,2)")
	private Double total;
	
	//-------------------------------
	//-- Relación Con User: N:1
	//-------------------------------
	
	@ManyToOne
	@JoinColumn(name = "user")
    @JsonIgnore  // Ignora la propiedad user durante la serialización
	private UserEntity user;

	
	public OrderEntity() {
	}


	public OrderEntity(Long idOrder, LocalDateTime date, Double total, UserEntity user) {
		this.idOrder = idOrder;
		this.date = date;
		this.total = total;
		this.user = user;
	}


	public Long getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "OrderEntity [idOrder=" + idOrder + ", date=" + date + ", total=" + total + ", user=" + user + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(date, idOrder, total, user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntity other = (OrderEntity) obj;
		return Objects.equals(date, other.date) && Objects.equals(idOrder, other.idOrder)
				&& Objects.equals(total, other.total) && Objects.equals(user, other.user);
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
