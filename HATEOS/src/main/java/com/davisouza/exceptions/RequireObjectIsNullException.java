package com.davisouza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequireObjectIsNullException extends RuntimeException {

	public RequireObjectIsNullException(String ex) {
		super(ex);
	}
	public RequireObjectIsNullException() {
		super("Não é permitido persistir um objeto nulo!");
	}
	
	private static final long serialVersionUID = 1L;

	
}
