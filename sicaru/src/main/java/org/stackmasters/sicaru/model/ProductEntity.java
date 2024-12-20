package org.stackmasters.sicaru.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "productos")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Long id;
	
    @Column(name = "categoria", length = 80, nullable = false)
    private String category; // Referencia a la entidad `CategoryEntity`
	
    @Column(name = "nombre_producto", length = 80, nullable = false)
    private String name;

    @Column(name = "descripcion", nullable = false)
    private String description;

    @Column(name = "precio", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<OrderEntity> orders;
	
    public ProductEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, id, name, orders, price, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductEntity other = (ProductEntity) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(orders, other.orders) && Objects.equals(price, other.price)
				&& Objects.equals(stock, other.stock);
	}       
}
