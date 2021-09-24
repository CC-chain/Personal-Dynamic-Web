package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Trs_Abilities;
import com.backend.source.repository.Trs_AbilitiesRepository;
import com.backend.source.service.Trs_AbilitiesService;

@Service
public class Trs_AbilitiesServiceImpl implements Trs_AbilitiesService {

	private Trs_AbilitiesRepository abilitiesRepository;
	
	public Trs_AbilitiesServiceImpl(Trs_AbilitiesRepository abilitiesRepository) {
		super();
		this.abilitiesRepository = abilitiesRepository;
	}
	
	@Override
	public Trs_Abilities saveAbility(Trs_Abilities ability) {
		return abilitiesRepository.save(ability);
	}

	@Override
	public List<Trs_Abilities> getAllAbilities() {
		return abilitiesRepository.findAll();
	}

	@Override
	public Trs_Abilities gelAbilityById(Trs_Abilities ability, long id) {
		return abilitiesRepository.findById(id).orElseThrow(() -> 
											new ResourceNotFoundException("Ability","Id",id));
	}

	@Override
	public Trs_Abilities updateAbility(Trs_Abilities ability, long id) {
		Trs_Abilities existingAbility = abilitiesRepository.findById(id).orElseThrow(() ->
															new ResourceNotFoundException("Ability","Id",id));
		
		existingAbility.setName(ability.getName());
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
