package org.stackmasters.sicaru.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
		
    @Column(name = "fecha_pedido", nullable = false, columnDefinition = "DATETIME")
    private String date;

    @Column(name = "total_pedido", nullable = false, columnDefinition = "DECIMAL(11,2)")
    private Double total;

    @Column(name = "estado_pedido", nullable = false, length =40)
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName="id_usuario", nullable = false)
    private UserEntity user;
    
    @ManyToMany
    @JoinTable(
        name = "pedidos_has_productos",
        joinColumns = @JoinColumn(name = "pedidos_id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "productos_id_producto")
    )
    private List<ProductEntity> products;
    
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<ReviewEntity> reviews;

	public OrderEntity() {
	}

	public OrderEntity(Long id, String date, Double total, String status, UserEntity user, List<ProductEntity> products,
			List<ReviewEntity> reviews) {
		this.id = id;
		this.date = date;
		this.total = total;
		this.status = status;
		this.user = user;
		this.products = products;
		this.reviews = reviews;
	}

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

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, products, reviews, status, total, user);
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
		return Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(products, other.products) && Objects.equals(reviews, other.reviews)
				&& Objects.equals(status, other.status) && Objects.equals(total, other.total)
				&& Objects.equals(user, other.user);
	}
    

}
