package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Org_Experiences;
import com.backend.source.repository.Org_ExperiencesRepository;
import com.backend.source.repository.Trs_ExperiencesRepository;
import com.backend.source.service.Org_ExperiencesService;

@Service
public class Org_ExperiencesServiceImpl implements Org_ExperiencesService{

	Org_ExperiencesRepository experiencesRepository;
	
	public Org_ExperiencesServiceImpl(Org_ExperiencesRepository experiencesRepository) {
		super();
		this.experiencesRepository = experiencesRepository;
	}
	
	@Override
	public Org_Experiences saveExperience(Org_Experiences experience) {
		return experiencesRepository.save(experience);
	}
	
	@Override
	public List<Org_Experiences> getAllExperiences() {
		return experiencesRepository.findAll();
	}

	@Override
	public Org_Experiences gelExperienceById(Org_Experiences experience, long id) {
		return experiencesRepository.findById(id).orElseThrow(() -> 
															new	ResourceNotFoundException("Experience","Id",id));
	}

	@Override
	public Org_Experiences updateExperience(Org_Experiences experience, long id) {
		Org_Experiences existingExperience = experiencesRepository.findById(id).orElseThrow(() -> 
															new	ResourceNotFoundException("Experience","Id",id));
		
		existingExperience.setInfo(experience.getInfo());
		existingExperience.setLocation(experience.getLocation());
		existingExperience.setName(experience.getName());
		existingExperience.setType(experience.getType());
		existingExperience.setWebSite(experience.getWebSite());
		existingExperience.setDate_First(experience.getDate_First());
		existingExperience.setDate_Last(experience.getDate_Last());
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
