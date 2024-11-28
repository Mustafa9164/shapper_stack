package com.lti.prc.shapper_stack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lti.prc.shapper_stack.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	@Transactional
	@Modifying
	@Query(value = "UPDATE Product p SET p.productPrice=?2 "
			+ "WHERE " + "p.productId = ?1")
	void updateProductPrice(int productId, double productPrice);

}
