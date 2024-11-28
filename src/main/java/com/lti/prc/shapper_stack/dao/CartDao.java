package com.lti.prc.shapper_stack.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.prc.shapper_stack.entity.Cart;
import com.lti.prc.shapper_stack.repository.CartRepo;

@Repository
public class CartDao {
	
	@Autowired
	private CartRepo repo;

	public Cart saveCart(Cart cart) {
		return repo.save(cart);
	}

}
