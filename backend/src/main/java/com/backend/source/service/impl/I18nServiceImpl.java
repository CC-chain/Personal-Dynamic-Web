package com.backend.source.service.impl;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.backend.source.model.Language;
import com.backend.source.model.Trs_Abilities;
import com.backend.source.service.I18nService;
import com.backend.source.service.LanguageService;
import com.backend.source.service.Trs_AbilitiesService;
import com.backend.source.service.Trs_BlogService;
import com.backend.source.service.Trs_ExperiencesService;
import com.backend.source.service.Trs_ProfileService;
import com.backend.source.service.Trs_TagsService;

@Service
public class I18nServiceImpl implements I18nService {
	private static final Logger LOGGER = LoggerFactory.getLogger(I18nServiceImpl.class);
	
	@Autowired
	Trs_AbilitiesService abilitiesService;
	
	@Autowired
	Trs_BlogService blogService;
	
	@Autowired
	Trs_ExperiencesService experiencesService;
	
	@Autowired
	Trs_ProfileService profileService;
	
	@Autowired
	Trs_TagsService tagsService;
	
	@Autowired
	LanguageService languageService;
	
	@Override
	public String getMessage(String value, String defaultValue, String DtoClass) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		LOGGER.info("currentLocale [{}]", currentLocale);
		return getMessage(value, defaultValue, DtoClass, currentLocale.getLanguage());
	}

	@Override
	public String getMessage(String value, String defaultValue, String DtoClass, String language) {
		LOGGER.info("langauge [{}]", language);
		return getMessageByLanguageAndContext(language, value, defaultValue, DtoClass); 
	}
	
	private String getMessageByLanguageAndContext(String language, String reference, String defaultValue, String dtoClass){
		Language languageDb = languageService.getLanguageByName(language);
		if(languageDb == null || StringUtils.isEmpty(language)) {
			Language languageDefault = languageService.getLanguageByName("Türkçe");
			language = languageDefault.getName();
		}
		switch (dtoClass){
		case "AbilitiesDto": {
	
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + dtoClass);
		}
		
	}

}
