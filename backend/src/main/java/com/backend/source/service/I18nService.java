package com.backend.source.service;

public interface I18nService {

	String getMessage(String value, String defaultValue, String DtoClass);
	
	String getMessage(String value, String defaultValue, String DtoClass, String language);
}
