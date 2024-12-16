package org.stackmasters.sicaru.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stackmasters.sicaru.model.ProductEntity;
import org.stackmasters.sicaru.repository.ProductRepository;


@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<ProductEntity> getAll(){
		return this.productRepository.findAll();
	}
	
	//Método para crear un nuevo Usuario
	public ProductEntity createProduct(ProductEntity newProduct) {
		return this.productRepository.save(newProduct);
	}

}
