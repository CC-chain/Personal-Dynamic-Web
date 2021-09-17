package com.backend.source.common.validator;


/**
 * 
 * @param <T>
 * 		Class of the object that we want to validate.
 * 
 * 
 * @author silence
 *
 */
public interface BaseValidator<T> {
	
	void validate(T obj);
	
}
