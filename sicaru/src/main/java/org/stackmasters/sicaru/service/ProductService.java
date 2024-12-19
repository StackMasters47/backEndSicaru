package org.stackmasters.sicaru.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stackmasters.sicaru.exceptions.ProductNotFoundException;
import org.stackmasters.sicaru.model.ProductEntity;
import org.stackmasters.sicaru.repository.ProductRepository;


@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	//Metodo para obtener todos los usuarios
	public List<ProductEntity> getAll(){
		return this.productRepository.findAll();
	}
	
	//Método para encontrar un producto por su id
	public ProductEntity productById(Long id) {
		return this.productRepository
				.findById(id)
				.orElseThrow (() -> new ProductNotFoundException(id));
	}
	
	//Método para crear un nuevo producto
	public ProductEntity createProduct(ProductEntity newProduct) {
		return this.productRepository.save(newProduct);
	}
	
	// Método para modificar un producto
	public ProductEntity updateProduct(Long productId, ProductEntity updateProduct) { 
		return	this.productRepository.findById(productId).map(existingProduct ->{
			existingProduct.setCategory(updateProduct.getCategory());
			existingProduct.setName(updateProduct.getName());
			existingProduct.setDescription(updateProduct.getDescription());
			existingProduct.setPrice(updateProduct.getPrice());
			existingProduct.setStock(updateProduct.getStock());
			return this.productRepository.save(existingProduct); 
		})
		.orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + productId)); 
	}
	
	//Método para eliminar un producto por id
	public void deleteProduct(Long id) {
		if (this.productRepository.existsById(id)) {
			this.productRepository.deleteById(id);
		} else {
			throw new ProductNotFoundException(id);
		}
	}
	
	// Método para agregar muchos productos
    public List<ProductEntity> createProducts(List<ProductEntity> products) {
        return productRepository.saveAll(products);
    }
		 

}
