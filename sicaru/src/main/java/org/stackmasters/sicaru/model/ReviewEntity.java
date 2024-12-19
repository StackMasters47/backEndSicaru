package org.stackmasters.sicaru.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resenas")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
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

    public ReviewEntity() {
    	
    }
    
    
    
	public ReviewEntity(Long id, Long product, Long user, String reviewDate, Integer rating, OrderEntity order) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.reviewDate = reviewDate;
		this.rating = rating;
		this.order = order;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getProduct() {
		return product;
	}



	public void setProduct(Long product) {
		this.product = product;
	}



	public Long getUser() {
		return user;
	}



	public void setUser(Long user) {
		this.user = user;
	}



	public String getReviewDate() {
		return reviewDate;
	}



	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	public OrderEntity getOrder() {
		return order;
	}



	public void setOrder(OrderEntity order) {
		this.order = order;
	}



	@Override
	public String toString() {
		return "ReviewEntity [id=" + id + ", product=" + product + ", user=" + user + ", reviewDate=" + reviewDate
				+ ", rating=" + rating + ", order=" + order + "]";
	}
	
	

    
    
    
    
    
    
    
    
}
    