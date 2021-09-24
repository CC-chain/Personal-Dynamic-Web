package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Org_Projects;
import com.backend.source.repository.Org_ProjectsRepository;
import com.backend.source.service.Org_ProjectsService;

@Service
public class Org_ProjectsServiceImpl implements Org_ProjectsService{

	Org_ProjectsRepository projectsRepository;
	
	public Org_ProjectsServiceImpl(Org_ProjectsRepository projectsRepository) {
		super();
		this.projectsRepository = projectsRepository;
	}
	
	@Override
	public Org_Projects saveProject(Org_Projects project) {
		return projectsRepository.save(project);
	}

	@Override
	public List<Org_Projects> getAllProject() {
		return projectsRepository.findAll();
	}

	@Override
	public Org_Projects gelProjectsById(Org_Projects project, long id) {
		return projectsRepository.findById(id).orElseThrow(() ->
															new ResourceNotFoundException("Project", "Id", id));
	}

	@Override
	public Org_Projects updateProject(Org_Projects project, long id) {
		Org_Projects existingProject = projectsRepository.findById(id).orElseThrow(() ->
															new ResourceNotFoundException("Project", "Id", id));
		
		existingProject.setAbout(project.getAbout());
		existingProject.setInfo(project.getInfo());
		existingProject.setName(project.getName());
		existingProject.setUrl(project.getUrl());
		projectsRepository.save(existingProject);
		
		return existingProject;
	}

	@Override
	public void deleteProject(long id) {
		projectsRepository.findById(id).orElseThrow(() ->
															new ResourceNotFoundException("Project", "Id", id));
		projectsRepository.deleteById(id);
	}

}
