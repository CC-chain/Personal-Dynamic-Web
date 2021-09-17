package com.backend.source.common.validator;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import com.backend.source.exception.FieldNotUniqueException;
import com.backend.source.exception.MissingRequiredFieldException;

/**
 * This component about some most used validation utilities. Implementation
 * is based on generic classes and types, in order to be specified on runtime.
 * This method is going to reduce boilerplate code and makes us to implement
 * multiple different implementations for the exact same functionality.
 *
 *@param <T>
 *		Class of the object that we check the validity. <T> most be DTO class in most cases
 *@param <S>
 *		Class of the object that could be found on db. <S> is a entity a class.
 *
 */

@Component
public class CommonValidatorUtils<T, S> {

	public void validateUniqueField(String fieldName , T checkingObj , S foundObj) {
		// Use BeanWrapper to get the value of a field that is specified on runtime.
		BeanWrapperImpl checkingObjWrapper = new BeanWrapperImpl(checkingObj);
		Object checkingObjId = checkingObjWrapper.getPropertyValue("Id");
		String checkingObjFieldValue = checkingObjWrapper.getPropertyValue(fieldName).toString();
		
		BeanWrapperImpl foundObjWrapper = new BeanWrapperImpl(foundObj);
		Object foundObjId = foundObjWrapper.getPropertyValue("Id");
		
		if(checkingObj == null)
			throw new FieldNotUniqueException(checkingObjFieldValue);
		
		if(checkingObjId != null) {
			
			if(checkingObjId != foundObjId) {
				throw new FieldNotUniqueException(checkingObjFieldValue);
			}
		}
	}
	
	 public void validateRequiredField(String fieldLabel, T fieldValue) {
	        if(fieldValue == null)
	            throw new MissingRequiredFieldException(fieldLabel);
	    }
}
