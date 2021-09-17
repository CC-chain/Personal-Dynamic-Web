package com.backend.source.exception;

import org.springframework.http.HttpStatus;

import com.backend.source.common.exception.BaseRuntimeException;

public class MissingRequiredFieldException extends BaseRuntimeException {

	public MissingRequiredFieldException(String message) {
		super("Field " + message + " is required!!" , HttpStatus.BAD_REQUEST);
	}

}
