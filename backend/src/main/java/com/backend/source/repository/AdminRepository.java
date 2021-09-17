package com.backend.source.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.source.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin , Long>{

		Optional<Admin> findByUser_Name(String User_Name);
}
