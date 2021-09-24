package com.backend.source.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.source.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
	Optional<Language> findByName(String Name);
}
