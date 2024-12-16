package org.stackmasters.sicaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stackmasters.sicaru.model.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {

}
