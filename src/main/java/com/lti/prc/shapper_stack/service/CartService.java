package com.lti.prc.shapper_stack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.prc.shapper_stack.dao.CartDao;
import com.lti.prc.shapper_stack.dao.ProductDao;
import com.lti.prc.shapper_stack.entity.Cart;
import com.lti.prc.shapper_stack.entity.Product;
import com.lti.prc.shapper_stack.util.ResponseStructure;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired 
	ProductDao productDao;

	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart, Integer id) {
		Optional<Product> optional = productDao.findById(id);
		if(optional.isPresent()) {
			List<Product> listOfProducts  = cart.getProducts();//This gets the current list of products in the cart.
			if(listOfProducts==null) {
				listOfProducts=new ArrayList<Product>();
			}
			listOfProducts.add(optional.get());			//Adds the product to the list of products.
			cart.setProducts(listOfProducts);			// Sets this updated product list in the cart.
		}
		
		 cart = calculatePriceOfCart(cart);
		 Cart savedCart = cartDao.saveCart(cart);
		 ResponseStructure<Cart> structure=new ResponseStructure<Cart>();
		 structure.setData(savedCart);
		 structure.setMesaage("Created");
		 structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.CREATED);
	}

	private Cart calculatePriceOfCart(Cart cart) {
		if(cart != null) {
			List<Product> listOfProducts = cart.getProducts();
			int size = listOfProducts.size();
			cart.setNumberOfPrducts(size);
			
			double totalPrice=0.0;
			for (Product product : listOfProducts) {
				product.setCart(cart);
				totalPrice+=product.getProductPrice();
			}
			cart.setTotalPrice(totalPrice);
		}
		return cart;
		
	}

	
}
