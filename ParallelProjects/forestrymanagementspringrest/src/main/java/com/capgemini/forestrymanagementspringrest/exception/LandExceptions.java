package com.capgemini.forestrymanagementspringrest.exception;

public class LandExceptions extends RuntimeException {
	String msg;

	public LandExceptions(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
