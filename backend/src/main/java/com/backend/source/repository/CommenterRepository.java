package com.backend.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.source.model.Commenter;

public interface CommenterRepository extends JpaRepository<Commenter, Long> {

}
