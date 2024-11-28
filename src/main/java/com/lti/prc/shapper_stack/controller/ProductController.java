package com.lti.prc.shapper_stack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.lti.prc.shapper_stack.entity.Product;
import com.lti.prc.shapper_stack.service.ProductService;
import com.lti.prc.shapper_stack.util.ResponseStructure;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product){
		return productService.saveProduct(product);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(){
		return productService.findAllProduct();
	}
	
	@GetMapping("/ProductId")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int id){
		return productService.findProductById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@RequestParam int id){
		return productService.deleteProduct(id);
	}
	@PutMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestParam int id, @RequestBody  Product product){
		return productService.updateProduct(id,product);
	}
	@PatchMapping("/updatePrice")
	public ResponseEntity<ResponseStructure<String>> updateProductPrice(@RequestParam int id, @RequestParam double productPrice){
		return productService.updateProductPrice(id,productPrice);
	}

}
