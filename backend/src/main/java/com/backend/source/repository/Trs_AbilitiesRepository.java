package com.backend.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.backend.source.model.Trs_Abilities;



public interface Trs_AbilitiesRepository extends JpaRepository<Trs_Abilities, Long>,Trs_AbilitiesCustomRepository, QuerydslPredicateExecutor {

}
