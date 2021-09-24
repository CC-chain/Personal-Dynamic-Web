package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Org_Experiences;

public interface Org_ExperiencesService {
	Org_Experiences saveExperience(Org_Experiences experience);

	List<Org_Experiences> getAllExperiences();

	Org_Experiences gelExperienceById(Org_Experiences experience, long id);

	Org_Experiences updateExperience(Org_Experiences experience, long id);

	void deleteExperience(long id);

}
