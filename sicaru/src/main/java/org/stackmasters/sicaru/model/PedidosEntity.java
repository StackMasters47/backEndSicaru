
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
@Table(name= "pedidos")
public class PedidosEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario",nullable = false)
    private UserEntity usuario; // Referencia a la entidad `CategoryEntity`
	
    @Column(name = "fecha_pedido", length = 80, nullable = false)
    private String fecha;

    @Column(name = "total_pedido", nullable = false)
    private Double total ;

    @Column(name = "estado_pedido", nullable = false)
    private Double estado;



	public PedidosEntity(Long id, UserEntity usuario, String fecha, Double total, Double estado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public UserEntity getUsuario() {
		return usuario;
	}



	public void setUsuario(UserEntity usuario) {
		this.usuario = usuario;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public Double getTotal() {
		return total;
	}



	public void setTotal(Double total) {
		this.total = total;
	}



	public Double getEstado() {
		return estado;
	}



	public void setEstado(Double estado) {
		this.estado = estado;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
}






	
    
    

