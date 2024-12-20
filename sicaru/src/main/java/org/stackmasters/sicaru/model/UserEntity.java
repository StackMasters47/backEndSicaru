package org.stackmasters.sicaru.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column (name = "nombre", length = 40, nullable = false, unique = false)
	private String name;
	
	@Column (name = "apellido", length = 60, nullable = false, unique = false)
	private String lastName;
	
	@Column (name = "contrasena", length = 40, nullable = false, unique = false)
	private String password;
	
	@Column (name = "correo", length = 60, nullable = false, unique = true)
	private String email;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<OrderEntity> orders;
	
	@OneToMany(mappedBy = "user")
	private List<AddressEntity> addresses;

	public UserEntity() {
	}

	public UserEntity(Long id, String name, String lastName, String password, String email, List<OrderEntity> orders,
			List<AddressEntity> addresses) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.orders = orders;
		this.addresses = addresses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public List<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addresses, email, id, lastName, name, orders, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(addresses, other.addresses) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(name, other.name) && Objects.equals(orders, other.orders)
				&& Objects.equals(password, other.password);
	}
	
	
	
}
