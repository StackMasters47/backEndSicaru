package org.stackmasters.sicaru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackmasters.sicaru.model.ProductEntity;
import org.stackmasters.sicaru.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//Mapear el metodo getAll()
	@GetMapping("/products")
	public List<ProductEntity> getProducts(){
		return this.productService.getAll();
	}
	
	@PostMapping("/new-product")
	public ProductEntity createProduct(@RequestBody ProductEntity newProduct) {
		return this.productService.createProduct(newProduct);
	}
}
