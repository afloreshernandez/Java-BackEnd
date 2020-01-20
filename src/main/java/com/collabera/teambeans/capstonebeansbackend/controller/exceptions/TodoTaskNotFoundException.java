package com.collabera.teambeans.capstonebeansbackend.controller.exceptions;

public class TodoTaskNotFoundException extends RuntimeException {
	public TodoTaskNotFoundException(String exception) {
		super(exception);
	}
}

