package com.backend.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.source.model.Org_Blog;

public interface BlogRepository extends JpaRepository<Org_Blog, Long> {

}
