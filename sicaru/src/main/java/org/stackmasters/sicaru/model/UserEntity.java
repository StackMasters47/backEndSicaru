package org.stackmasters.sicaru.model;

import java.util.List;

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
	private String lastname;
	
	@Column (name = "contrasena", length = 40, nullable = false, unique = false)
	private String password;
	
	@Column (name = "correo", length = 60, nullable = false, unique = true)
	private String email;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<OrderEntity> orders;
	
	@OneToMany(mappedBy = "user")
	private List<AddressEntity> addresses;
	
}
