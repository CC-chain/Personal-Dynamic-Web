package com.backend.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.source.model.Org_Tags;

public interface TagsRepository extends JpaRepository<Org_Tags, Long> {

}
