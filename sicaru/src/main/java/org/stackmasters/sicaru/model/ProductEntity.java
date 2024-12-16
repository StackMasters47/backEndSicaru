package org.stackmasters.sicaru.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//id_categoria nombre descripcion precio stock
import jakarta.persistence.Table;

@Entity
@Table(name= "productos")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria",nullable = false)
    private CategoryEntity categoria; // Referencia a la entidad `CategoryEntity`
	
    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

	public ProductEntity() {
	}

	public ProductEntity(Long id, CategoryEntity categoria, String nombre, String descripcion, Double precio, Integer stock) {
		this.id = id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoryEntity categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descripcion, id, nombre, precio, stock);
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
		return Objects.equals(categoria, other.categoria) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio) && Objects.equals(stock, other.stock);
	}
	
	
    
    
}
