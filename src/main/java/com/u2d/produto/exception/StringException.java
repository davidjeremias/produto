package com.u2d.produto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class StringException extends Exception{

	private static final long serialVersionUID = 2893361616135406189L;

	public StringException(String msg){
        super(msg);
    }
}
