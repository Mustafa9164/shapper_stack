package com.lti.prc.shapper_stack.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lti.prc.shapper_stack.dao.ProductDao;
import com.lti.prc.shapper_stack.entity.Product;
import com.lti.prc.shapper_stack.exception.ProductNotFoundException;
import com.lti.prc.shapper_stack.util.ResponseStructure;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Product saveProduct = productDao.saveProduct(product);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setData(saveProduct);
		structure.setMesaage("product saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		List<Product> findAll = productDao.findAll();
		ResponseStructure<List<Product>> structure=new ResponseStructure<List<Product>>();
		structure.setData(findAll);
		structure.setMesaage("All Product Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> findProductById(int id) {
		Optional<Product> findById = productDao.findById(id);
		if(findById.isPresent()) {
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setData(findById.get());
		structure.setMesaage("Product Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
	}
		throw new ProductNotFoundException("Product Withe Given id = " + id + " Not Found");
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id) {
		if(productDao.isPresent(id)) {
			productDao.deleteProduct(id);
			ResponseStructure<String> structure=new ResponseStructure<String>();
			structure.setData("product deleted sucessfully");
			structure.setMesaage("product deleted");
			structure.setStatusCode(HttpStatus.NO_CONTENT.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NO_CONTENT);
		}
		throw new ProductNotFoundException("Product Not Found");
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) {
		if(productDao.isPresent(id)) {
			product.setProductId(id);
			Product updatedProduct = productDao.saveProduct(product);
			ResponseStructure<Product> structure=new ResponseStructure<Product>();
			structure.setData(updatedProduct);
			structure.setMesaage("Product updated sucessfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Not FOund");
	}

	public ResponseEntity<ResponseStructure<String>> updateProductPrice(int id, double productPrice) {
	    if (productDao.isPresent(id)) {
	        productDao.updateProductPrice(id, productPrice);
	        ResponseStructure<String> structure = new ResponseStructure<>();
	        structure.setData("Product price updated successfully");
	        structure.setMesaage(null);  // Correct spelling of setMessage
	        structure.setStatusCode(HttpStatus.OK.value());  // Correct spelling of setStatusCode
	        return new ResponseEntity<>(structure, HttpStatus.OK);
	    }
		throw new ProductNotFoundException("Product Not FOund");
	}

}
