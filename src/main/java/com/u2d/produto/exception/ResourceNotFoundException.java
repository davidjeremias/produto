package com.u2d.produto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -8361324440537318965L;
	
	public ResourceNotFoundException(String exception) {
		super(exception);
	}

}
