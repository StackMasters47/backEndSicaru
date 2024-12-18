package org.stackmasters.sicaru.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_user;
	
	@Column(name = "nombre", length = 100, nullable = false, unique = false)
	private String name;
	
	@Column(name = "apellido", length = 100, nullable = false, unique = false)
	private String lastName;
	
	@Column(name = "correo", length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(name = "contrasena", length = 50, nullable = false, unique = false)
	private String password;
	
	/*@OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL)
	private List<OrderEntity> orders;  //Instanciar OrderEntity
	
	@OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL)
	private List<AddressEntity> addresses; //Instanciar AddressEntity*/

	public UserEntity() {
		
	}

	public UserEntity(Long id_user, String name, String lastName, String email, String password) {
		this.id_user = id_user;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		//this.orders = orders;
		//this.addresses = addresses;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
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
    */
	
	@Override
	public String toString() {
		return "UserEntity [id_user=" + id_user + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id_user, lastName, name, password);
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
		return Objects.equals(email, other.email) && Objects.equals(id_user, other.id_user)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}

	
	
}
