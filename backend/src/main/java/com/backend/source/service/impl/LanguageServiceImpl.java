package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Language;
import com.backend.source.repository.LanguageRepository;
import com.backend.source.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService{

	private LanguageRepository languageRepository;
	
	public LanguageServiceImpl(LanguageRepository languageRespository) {
		super();
		this.languageRepository= languageRespository;
	}
	
	@Override
	public Language saveLanguage(Language language) {
		return languageRepository.save(language);
	}

	@Override
	public List<Language> getAllLanguages() {
		return languageRepository.findAll();
	}

	@Override
	public Language getLanguage(Language language, long id) {
		return languageRepository.findById(id).orElseThrow(() -> 
											new ResourceNotFoundException("Language","Id",id));
	}

	@Override
	public Language updateLanguage(Language language, long id) {
		Language existingLanguage = languageRepository.findById(id).orElseThrow(() ->
															new ResourceNotFoundException("Language","Id",id));
		
		existingLanguage.setName(language.getName());
		languageRepository.save(existingLanguage);
		
		return existingLanguage;
	}

	@Override
	public void deleteLanguage(long id) {
		languageRepository.findById(id).orElseThrow(() ->
															new ResourceNotFoundException("Language","Id",id));
		languageRepository.deleteById(id);
	}

	@Override
	public Language getLanguageByName(String languageName) {
		return languageRepository.findByName(languageName).orElseThrow(() -> 
														new ResourceNotFoundException("Language","Name",languageName));
	}

}
