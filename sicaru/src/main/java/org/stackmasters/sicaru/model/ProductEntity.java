package org.stackmasters.sicaru.model;

import java.util.List;

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
    
}
