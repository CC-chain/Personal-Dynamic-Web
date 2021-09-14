package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Org_Abilities;
import com.backend.source.repository.AbilitiesRepository;
import com.backend.source.service.AbilitiesService;

@Service
public class AbilitiesServiceImpl implements AbilitiesService {

	private AbilitiesRepository abilitiesRepository;
	
	public AbilitiesServiceImpl(AbilitiesRepository abilitiesRepository) {
		super();
		this.abilitiesRepository = abilitiesRepository;
	}
	
	@Override
	public Org_Abilities saveAbility(Org_Abilities ability) {
		return abilitiesRepository.save(ability);
	}

	@Override
	public List<Org_Abilities> getAllAbilities() {
		return abilitiesRepository.findAll();
	}

	@Override
	public Org_Abilities gelAbilityById(Org_Abilities ability, long id) {
		return abilitiesRepository.findById(id).orElseThrow(() -> 
											new ResourceNotFoundException("Ability","Id",id));
	}

	@Override
	public Org_Abilities updateAbility(Org_Abilities ability, long id) {
		Org_Abilities existingAbility = abilitiesRepository.findById(id).orElseThrow(() ->
															new ResourceNotFoundException("Ability","Id",id));
		
		existingAbility.setName(ability.getName());
		existingAbility.setRate(ability.getRate());
		existingAbility.setType(ability.getType());
		abilitiesRepository.save(existingAbility);
		
		return existingAbility;
	}

	@Override
	public void deleteAbility(long id) {
		abilitiesRepository.findById(id).orElseThrow(() ->
															new ResourceNotFoundException("Ability","Id",id));
		abilitiesRepository.deleteById(id);
	}

}
