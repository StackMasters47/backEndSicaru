package org.stackmasters.sicaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stackmasters.sicaru.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>{

}
