package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Org_Abilities;

public interface AbilitiesService {
	Org_Abilities saveAbility(Org_Abilities ability);

	List<Org_Abilities> getAllAbilities();

	Org_Abilities gelAbilityById(Org_Abilities ability, long id);

	Org_Abilities updateAbility(Org_Abilities ability, long id);

	void deleteAbility(long id);

}
