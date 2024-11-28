package com.lti.prc.shapper_stack.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private T data;
	private String mesaage;
	private int statusCode;

}
