package com.backend.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.source.model.Org_Profile;

public interface ProfileRepository extends JpaRepository<Org_Profile, Long> {

}
