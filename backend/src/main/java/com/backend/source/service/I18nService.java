package com.backend.source.service;

public interface I18nService {

	String getMessage(String value, String defaultValue, Class DtoClass, String fieldName);
	
	String getMessage(String value, String defaultValue, Class DtoClass, String fieldName, String language);
}
