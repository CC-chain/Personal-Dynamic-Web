package com.backend.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.source.model.Org_Experiences;

public interface ExperiencesRepository extends JpaRepository<Org_Experiences, Long> {

}
