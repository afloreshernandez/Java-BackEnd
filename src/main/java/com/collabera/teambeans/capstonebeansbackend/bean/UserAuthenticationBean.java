package com.collabera.teambeans.capstonebeansbackend.bean;

@Deprecated
public class UserAuthenticationBean {

	private String message;
	
	public UserAuthenticationBean (String message) {
		this.setMessage(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	 @Override
	    public String toString() {
	        return String.format("Welcome user,  [message=%s]", message);
	    }	
}