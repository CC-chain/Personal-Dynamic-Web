package com.backend.source.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.source.model.Trs_Abilities;
import com.backend.source.repository.Trs_AbilitiesCustomRepository;
import com.backend.source.repository.Trs_AbilitiesRepository;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

public class Trs_AbilitiesImpl implements Trs_AbilitiesCustomRepository {

	@Autowired
	private Trs_AbilitiesRepository abilitiesRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Trs_Abilities> findBy(String columnName, String columnValue) {
		Path<Trs_Abilities> abilites= Expressions.path(Trs_Abilities.class, "Trs_Abilities");
		Path<String> abilitiesColumnName = Expressions.path(String.class, abilites ,columnName);
		Expression<String> abilitiesValueExpression = Expressions.constant(columnValue);
		BooleanExpression fieldEquealsExpression = Expressions.predicate(Ops.EQ, abilitiesColumnName, abilitiesValueExpression );
		
		return (List<Trs_Abilities>) abilitiesRepository.findAll(fieldEquealsExpression);
	}

}
