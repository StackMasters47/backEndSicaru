package org.stackmasters.sicaru.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "direcciones")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direccion")
	private Long idAddress;
	
	@Column(name = "nombre_completo", length = 100, nullable = false, unique = false)
	private String fullName;
	
	@Column(name = "calle_numero", length = 100, nullable = false, unique = false)
	private String streetAndNumber;
	
	@Column(name = "codigo_postal", length = 20, nullable = false, unique = false)
	private String postalCode;
	
	@Column(name = "ciudad", length = 100, nullable = false, unique = false)
	private String city;
	
	@Column(name = "estado", length = 100, nullable = false, unique = false)
	private String state;
	
	/*
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	@JsonIgnore
	public UserEntity user;*/

	public AddressEntity() {
		
	}

	public Long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
	
}
