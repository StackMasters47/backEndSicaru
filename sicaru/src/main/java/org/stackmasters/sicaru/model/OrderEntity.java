package org.stackmasters.sicaru.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName="id_usuario", nullable = false)
    @JsonIgnore
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

}
