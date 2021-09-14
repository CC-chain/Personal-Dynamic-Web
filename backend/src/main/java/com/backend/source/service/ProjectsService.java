package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Org_Projects;

public interface ProjectsService {
	Org_Projects saveProject(Org_Projects project);

	List<Org_Projects> getAllProject();

	Org_Projects gelProjectsById(Org_Projects project, long id);

	Org_Projects updateProject(Org_Projects project, long id);

	void deleteProject(long id);

}
