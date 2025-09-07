package com.cjc.app.exception;

public class NoSuchUserExistsException extends RuntimeException {

	public NoSuchUserExistsException(String msg) {

		super(msg);
	}
}
