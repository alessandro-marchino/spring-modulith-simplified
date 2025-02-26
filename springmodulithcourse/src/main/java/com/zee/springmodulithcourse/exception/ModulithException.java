package com.zee.springmodulithcourse.exception;

import java.io.Serial;

public class ModulithException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;

	public ModulithException() {
		super();
	}

	public ModulithException(String message) {
		super(message);
	}

}
