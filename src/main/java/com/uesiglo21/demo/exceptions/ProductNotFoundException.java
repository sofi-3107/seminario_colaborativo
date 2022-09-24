package com.uesiglo21.demo.exceptions;

public class ProductNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String mensaje) {
		super(mensaje);
	}

}
