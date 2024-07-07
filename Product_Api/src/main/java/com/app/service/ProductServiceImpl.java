package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ProductDto;
import com.app.entity.Product;
import com.app.enums.Category;
import com.app.exception.ProductResourceException;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductServiec {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public Product getProductById(Long id) throws ProductResourceException {
		Optional<Product> p = productRepository.findById(id);
		if (p == null) {
			throw new ProductResourceException("product not found");
		} else {
			return p.orElse(null);
		}
	}

	@Override
	public ArrayList<Product> getProductByCategory(Category cat) throws ProductResourceException {
		ArrayList<Product> plist = new ArrayList<>();
		plist.addAll(productRepository.findByCategory(cat));
		return plist;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(ProductDto p) throws ProductResourceException {
		// TODO Auto-generated method stub
		Product pobj = mapper.map(p, Product.class);		
		Optional<Product> obj = productRepository.findByProductCode(pobj.getProductCode());

		if (obj.isPresent()) {
			throw new ProductResourceException("Duplicate prod found");

		}
		return productRepository.save(pobj);

	}

	@Override
	public Product updateProduct(Long id, ProductDto pnew) throws ProductResourceException {
		Optional<Product> pold = productRepository.findById(id);
		System.out.println("old p" + pold);

		Product newp = mapper.map(pnew, Product.class);
		pold.get().setName(newp.getName());
		pold.get().setMfd(newp.getMfd());
		pold.get().setCategory(newp.getCategory());
		pold.get().setProductCode(newp.getProductCode());
		System.out.println("update product" + pold);
		if (pold.get() == null) {
			throw new ProductResourceException("Product not found");
		} else {
			return pold.get();
		}
	}

	@Override
	public Product delete(Long id) throws ProductResourceException {
		Optional<Product> p = productRepository.findById(id);
		if (p.get() == null) {
			throw new ProductResourceException("product not found");
		}
		System.out.println(" Deleting Prduct id : " + id + " " + p.get());
		productRepository.delete(p.get());
		return p.get();
	}

}
