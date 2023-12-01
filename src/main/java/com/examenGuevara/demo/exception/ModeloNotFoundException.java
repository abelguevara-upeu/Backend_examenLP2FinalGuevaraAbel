package com.examenGuevara.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 471326526544433369L;

	public ModeloNotFoundException(String mensaje)
	{
		super(mensaje);
	}
}
