package com.collabera.teambeans.capstonebeansbackend.controller.exceptions;

public class TodoTaskNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TodoTaskNotFoundException(String exception) {
		super(exception);
	}
}