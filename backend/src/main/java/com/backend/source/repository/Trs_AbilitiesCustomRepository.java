package com.backend.source.repository;

import java.util.List;

import com.backend.source.model.Trs_Abilities;

public interface Trs_AbilitiesCustomRepository {
	List<Trs_Abilities> findBy(String columnName, String columnValue);
}
