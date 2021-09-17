package com.backend.source.exception;

import org.springframework.http.HttpStatus;

import com.backend.source.common.exception.BaseRuntimeException;

public class FieldNotUniqueException extends BaseRuntimeException{

	public FieldNotUniqueException(String message) {
		super("Field " + message + "is not unique", HttpStatus.BAD_REQUEST );
	}

}
