package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Org_Profile;

public interface Org_ProfileService {
	Org_Profile saveProfile(Org_Profile profile);

	List<Org_Profile> getAllProfiles();

	Org_Profile gelProfileById(Org_Profile profile, long id);

	Org_Profile updateProfile(Org_Profile profile, long id);

	void deleteProfile(long id);

}
