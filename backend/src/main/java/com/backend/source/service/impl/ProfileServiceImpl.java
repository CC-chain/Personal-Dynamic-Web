package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Org_Profile;
import com.backend.source.repository.ProfileRepository;
import com.backend.source.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	ProfileRepository profileRepository;
	
	public ProfileServiceImpl(ProfileRepository profileRepository) {
		super();
		this.profileRepository = profileRepository;
	}
	
	@Override
	public Org_Profile saveProfile(Org_Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public List<Org_Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@Override
	public Org_Profile gelProfileById(Org_Profile profile, long id) {
		return profileRepository.findById(id).orElseThrow(() -> 
													new ResourceNotFoundException("Profile","Id",id));
	}

	@Override
	public Org_Profile updateProfile(Org_Profile profile, long id) {
		Org_Profile existingProfile = profileRepository.findById(id).orElseThrow(() -> 
													new ResourceNotFoundException("Profile","Id",id));
		
		existingProfile.setName(profile.getName());
		existingProfile.setAbout(profile.getAbout());
		existingProfile.setLocation(profile.getLocation());
		existingProfile.setDateOfBirth(profile.getDateOfBirth());
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
