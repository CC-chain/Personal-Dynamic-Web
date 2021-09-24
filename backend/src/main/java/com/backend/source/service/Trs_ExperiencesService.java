package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Trs_Experiences;


public interface Trs_ExperiencesService {
	Trs_Experiences saveExperience(Trs_Experiences experience);

	List<Trs_Experiences> getAllExperiences();

	Trs_Experiences gelExperienceById(Trs_Experiences experience, long id);

	Trs_Experiences updateExperience(Trs_Experiences experience, long id);

	void deleteExperience(long id);

}
