
package org.stackmasters.sicaru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stackmasters.sicaru.model.PedidosEntity;

public interface PedidosRepository extends JpaRepository<PedidosEntity,Long>{

	List<PedidosEntity> findAll();

	PedidosEntity save(PedidosEntity newPedido);

}