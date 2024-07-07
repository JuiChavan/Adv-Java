package com.app.service;

import java.util.List;

import com.app.dto.ProductDto;
import com.app.entity.Product;
import com.app.enums.Category;
import com.app.exception.ProductResourceException;

public interface ProductServiec {
	
	//GET
	public Product getProductById(Long id) throws ProductResourceException;
	public List<Product> getProductByCategory (Category cat) throws ProductResourceException;
	public List<Product> getAllProduct() ;
	
	//POST
	public 	Product addProduct(ProductDto product) throws ProductResourceException;;
	
	//Put
	public Product updateProduct(Long  id,ProductDto product) throws ProductResourceException;
	
	//delete
	public Product delete(Long id) throws ProductResourceException;
	
	
}
