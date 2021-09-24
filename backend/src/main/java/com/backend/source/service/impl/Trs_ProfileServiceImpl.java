package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Trs_Profile;
import com.backend.source.repository.Trs_ProfileRepository;
import com.backend.source.service.Trs_ProfileService;

@Service
public class Trs_ProfileServiceImpl implements Trs_ProfileService{

	Trs_ProfileRepository profileRepository;
	
	public Trs_ProfileServiceImpl(Trs_ProfileRepository profileRepository) {
		super();
		this.profileRepository = profileRepository;
	}
	
	@Override
	public Trs_Profile saveProfile(Trs_Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public List<Trs_Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@Override
	public Trs_Profile gelProfileById(Trs_Profile profile, long id) {
		return profileRepository.findById(id).orElseThrow(() -> 
													new ResourceNotFoundException("Profile","Id",id));
	}

	@Override
	public Trs_Profile updateProfile(Trs_Profile profile, long id) {
		Trs_Profile existingProfile = profileRepository.findById(id).orElseThrow(() -> 
													new ResourceNotFoundException("Profile","Id",id));
		
		existingProfile.setName(profile.getName());
		existingProfile.setAbout(profile.getAbout());
		existingProfile.setLocation(profile.getLocation());
		profileRepository.save(existingProfile);

		return existingProfile;
	}

	@Override
	public void deleteProfile(long id) {
		profileRepository.findById(id).orElseThrow(() -> 
													new ResourceNotFoundException("Profile","Id",id));
		profileRepository.deleteById(id);
	}

}
