package com.lti.prc.shapper_stack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lti.prc.shapper_stack.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleProductNotFoundException(ProductNotFoundException ex){
		
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData("");
		structure.setMesaage(ex.getMessage());
		structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}

}
