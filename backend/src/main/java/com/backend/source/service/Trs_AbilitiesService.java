package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Trs_Abilities;

public interface Trs_AbilitiesService {
	Trs_Abilities saveAbility(Trs_Abilities ability);

	List<Trs_Abilities> getAllAbilities();

	Trs_Abilities getAbilityById(Trs_Abilities ability, long id);

	Trs_Abilities updateAbility(Trs_Abilities ability, long id);
	
	Trs_Abilities getAbilityByColumnNameAndValue(String columnName , String columnValue);

	void deleteAbility(long id);

}
