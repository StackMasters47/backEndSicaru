package org.stackmasters.sicaru.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direcciones")
public class AddressEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id;

    @Column(name = "nombre_completo", length = 80, nullable = false)
    private String fullName;

    @Column(name = "calle_numero", length = 45, nullable = false)
    private String streetAndNumber;

    @Column(name = "codigo_postal", length = 10, nullable = false)
    private String postalCode;

    @Column(name = "estado", length = 45, nullable = false)
    private String state;

    @Column(name = "ciudad", length = 45, nullable = false)
    private String city;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private UserEntity user;

}
