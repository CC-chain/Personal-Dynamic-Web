package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Trs_Experiences;
import com.backend.source.repository.Trs_ExperiencesRepository;
import com.backend.source.service.Trs_ExperiencesService;

@Service
public class Trs_ExperiencesServiceImpl implements Trs_ExperiencesService{

	Trs_ExperiencesRepository experiencesRepository;
	
	public Trs_ExperiencesServiceImpl(Trs_ExperiencesRepository experiencesRepository) {
		super();
		this.experiencesRepository = experiencesRepository;
	}
	
	@Override
	public Trs_Experiences saveExperience(Trs_Experiences experience) {
		return experiencesRepository.save(experience);
	}
	
	@Override
	public List<Trs_Experiences> getAllExperiences() {
		return experiencesRepository.findAll();
	}

	@Override
	public Trs_Experiences gelExperienceById(Trs_Experiences experience, long id) {
		return experiencesRepository.findById(id).orElseThrow(() -> 
															new	ResourceNotFoundException("Experience","Id",id));
	}

	@Override
	public Trs_Experiences updateExperience(Trs_Experiences experience, long id) {
		Trs_Experiences existingExperience = experiencesRepository.findById(id).orElseThrow(() -> 
															new	ResourceNotFoundException("Experience","Id",id));
		
		existingExperience.setInfo(experience.getInfo());
		existingExperience.setLocation(experience.getLocation());
		existingExperience.setName(experience.getName());
		existingExperience.setType(experience.getType());
		experiencesRepository.save(existingExperience);
		
		return existingExperience;
		
	}

	@Override
	public void deleteExperience(long id) {
		experiencesRepository.findById(id).orElseThrow(() -> 
															new	ResourceNotFoundException("Experience","Id",id));
		experiencesRepository.deleteById(id);
	}

}
