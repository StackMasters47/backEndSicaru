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
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column (name = "nombre", length = 30, nullable = false, unique = false)
	private String name;
	
	@Column (name = "apellido", length = 30, nullable = false, unique = false)
	private String lastName;
	
	@Column (name = "telefono", length = 30, nullable = false, unique = true)
	private String telephone;
	
	@Column (name = "correo", length = 30, nullable = false, unique = true)
	private String email;
	
	@Column (name = "contrasena", length = 30, nullable = false, unique = false)
	private String password;
	
	@Column (name = "direccion", length = 250, nullable = true, unique = false)
	private String address;
	
	public UsuarioEntity() {
		
	}

	public UsuarioEntity(Long id, String name, String lastName, String telephone, String email, String password,
			String address) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.address = address;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", name=" + name + ", lastName=" + lastName + ", telephone=" + telephone
				+ ", email=" + email + ", password=" + password + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, lastName, name, password, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(telephone, other.telephone);
	}
}
