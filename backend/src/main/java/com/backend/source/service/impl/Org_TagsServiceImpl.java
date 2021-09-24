package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Org_Tags;
import com.backend.source.repository.Org_TagsRepository;
import com.backend.source.service.Org_TagsService;

@Service
public class Org_TagsServiceImpl implements Org_TagsService{

	Org_TagsRepository tagsRepository;
	
	public Org_TagsServiceImpl(Org_TagsRepository tagsRepository) {
		super();
		this.tagsRepository = tagsRepository;
	}

	@Override
	public Org_Tags saveTag(Org_Tags tag) {
		return tagsRepository.save(tag);
	}

	@Override
	public List<Org_Tags> getAllTags() {
		return tagsRepository.findAll();
	}

	@Override
	public Org_Tags gelTagById(Org_Tags tag, long id) {
		return tagsRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Tag", "Id", id));
	}

	@Override
	public Org_Tags updateTag(Org_Tags tag, long id) {
		Org_Tags existingTag = tagsRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Tag", "Id", id));
		
		existingTag.setName(tag.getName());
		tagsRepository.save(existingTag);
		
		return existingTag;
	}

	@Override
	public void deleteTag(long id) {
		tagsRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Tag", "Id", id));
		tagsRepository.deleteById(id);
	}

}
