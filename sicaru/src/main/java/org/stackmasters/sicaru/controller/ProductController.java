package org.stackmasters.sicaru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//Obtener un producto por id
	@GetMapping("/products/{id}")
	public ProductEntity findById(@PathVariable(name = "id") Long id) {
		return this.productService.productById(id);
	}
	
	@PostMapping("/new-product")
	public ProductEntity createProduct(@RequestBody ProductEntity newProduct) {
		return this.productService.createProduct(newProduct);
	}
	
	//Metodo para agregar muchos productos
	@PostMapping("/add-products")
    public ResponseEntity<List<ProductEntity>> addProducts(@RequestBody List<ProductEntity> products) {
        List<ProductEntity> savedProducts = productService.createProducts(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducts);
    }
	
	@PutMapping("/update-product/{id}") 
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable("id") Long productId, @RequestBody ProductEntity updateProduct) { 
	    try { 
	        // Llamar al servicio para actualizar el producto 
	        ProductEntity updatedProduct = productService.updateProduct(productId, updateProduct); 
	        return ResponseEntity.ok(updatedProduct); 
	    } catch (RuntimeException e) { 
	        // Manejo de error si el producto no existe 
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
	    } 
	}
	
	//Endpoint para eliminar un producto por id
	@DeleteMapping("/delete-product/{id}")
	public void deleteUser(@PathVariable (name = "id") Long id) {
		this.productService.deleteProduct(id);
	}
}
