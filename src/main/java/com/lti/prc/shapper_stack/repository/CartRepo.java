package com.lti.prc.shapper_stack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.prc.shapper_stack.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
