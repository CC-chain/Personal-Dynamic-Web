package com.backend.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.source.model.Org_Projects;

public interface ProjectsRepository extends JpaRepository<Org_Projects, Long> {

}
