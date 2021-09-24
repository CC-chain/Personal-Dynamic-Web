package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Trs_Profile;


public interface Trs_ProfileService {
	Trs_Profile saveProfile(Trs_Profile profile);

	List<Trs_Profile> getAllProfiles();

	Trs_Profile gelProfileById(Trs_Profile profile, long id);

	Trs_Profile updateProfile(Trs_Profile profile, long id);

	void deleteProfile(long id);

}
