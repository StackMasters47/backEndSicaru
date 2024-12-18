package org.stackmasters.sicaru.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resenas")
public class ReviewEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_resena")
    private Long id;

	@Column(name = "id_producto", nullable = false)
    private Long product;

	@Column(name = "id_usuario", nullable = false)
    private Long user;

    @Column(name = "fecha_resena", nullable = false)
    private String reviewDate;

    @Column(name = "calificacion", nullable = false)
    private Integer rating;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    private OrderEntity order;
}
