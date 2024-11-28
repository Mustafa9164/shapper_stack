package com.lti.prc.shapper_stack.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.prc.shapper_stack.entity.Product;
import com.lti.prc.shapper_stack.repository.ProductRepo;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepo productRepo;

	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public Optional<Product> findById(int id) {
		return productRepo.findById(id);
	}

	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}
	
	public boolean isPresent(int id) {
		return productRepo.existsById(id);
	}
	
	public void updateProductPrice(int id,double productPrice) {
		 productRepo.updateProductPrice(id,productPrice);
	}

}
