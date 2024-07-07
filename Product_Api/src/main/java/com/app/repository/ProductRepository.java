package com.app.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Product;
import com.app.enums.Category;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("select p from Product p where p.category=:category")
	public ArrayList<Product> findByCategory(Category category);

	//@Query("select p from Product p where p.productCode=:productCode")
	public Optional<Product> findByProductCode(String productCode);
}
