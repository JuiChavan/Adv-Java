package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

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

import com.app.dto.ProductDto;
import com.app.entity.Product;
import com.app.enums.Category;
import com.app.exception.ProductResourceException;
import com.app.service.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;

	//Getting all product resource
	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		List<Product> p = productServiceImpl.getAllProduct();
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not available ");
		}
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}

	//Add product resource
	@PostMapping()
	public ResponseEntity<?> addProduct(@RequestBody ProductDto p) throws ProductResourceException {
		Product p1 = productServiceImpl.addProduct(p);
		if (p1 == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product already present");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Added product resource" + p1);

	}

	//Get product by ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) throws ProductResourceException {
		Product p = productServiceImpl.getProductById(id);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found ");
		}
		//Setting error code and http status
		return ResponseEntity.status(HttpStatus.OK).body("Product by id "+id +" "+p);
	}
	
	
	//Get product by category
	@GetMapping("/getByCategory/{category}")
	public ResponseEntity<?> getByCategory(@PathVariable Category category) throws ProductResourceException{
		Category cat=Category.valueOf(category.toString().toUpperCase());
		System.out.println("cat "+cat);
		ArrayList<Product> p=productServiceImpl.getProductByCategory(cat);
		if(p==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product by category not found");
		}
		else {
			p.forEach(obj -> System.out.println(obj));
			return ResponseEntity.status(HttpStatus.FOUND).body("Poduct by category "+p);
		}
	}
	
	
	//Update Product by ID
	@PutMapping("{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody ProductDto p) throws ProductResourceException{
		Product pobj=productServiceImpl.updateProduct(id, p);
		return ResponseEntity.status(HttpStatus.OK).body("Updated product"+p);
	}
	
	//Deleting product by ID
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) throws ProductResourceException{
		Product p=productServiceImpl.delete(id);
		if(p==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( "Product not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Deleted ");

	}
}
