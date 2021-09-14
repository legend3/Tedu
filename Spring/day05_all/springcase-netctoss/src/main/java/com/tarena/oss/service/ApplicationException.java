package com.tarena.oss.service;
/**
 * 应用异常类。
 *
 */
public class ApplicationException 
	extends RuntimeException {

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}
	
}
