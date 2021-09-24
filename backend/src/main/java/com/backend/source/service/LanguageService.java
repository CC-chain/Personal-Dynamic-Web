package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Language;

public interface LanguageService {
	Language saveLanguage(Language language);

	List<Language> getAllLanguages();

	Language getLanguage(Language language, long id);
	
	Language getLanguageByName(String languageName);

	Language updateLanguage(Language language, long id);

	void deleteLanguage(long id);

}
