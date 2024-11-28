package com.lti.prc.shapper_stack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.prc.shapper_stack.entity.Cart;
import com.lti.prc.shapper_stack.service.CartService;
import com.lti.prc.shapper_stack.util.ResponseStructure;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/saveCart")
	public ResponseEntity<ResponseStructure<Cart>> saveCart(@RequestBody Cart cart, @RequestParam(required = false, name = "productId") Integer id){
		return cartService.saveCart(cart,id);
	}
	

}
