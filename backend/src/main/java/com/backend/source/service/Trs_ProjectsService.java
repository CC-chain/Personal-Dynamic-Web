package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Trs_Projects;


public interface Trs_ProjectsService {
	Trs_Projects saveProject(Trs_Projects project);

	List<Trs_Projects> getAllProject();

	Trs_Projects gelProjectsById(Trs_Projects project, long id);

	Trs_Projects updateProject(Trs_Projects project, long id);

	void deleteProject(long id);

}
