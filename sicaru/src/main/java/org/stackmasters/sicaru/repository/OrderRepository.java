package org.stackmasters.sicaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stackmasters.sicaru.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Long>{
	/*
	 * List<OrderEntity> findAll(); OrderEntity save(OrderEntity newPedido);
	 */
}
