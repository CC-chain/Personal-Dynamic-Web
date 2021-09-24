package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Trs_Tags;
import com.backend.source.repository.Trs_TagsRepository;
import com.backend.source.service.Trs_TagsService;

@Service
public class Trs_TagsServiceImpl implements Trs_TagsService{

	Trs_TagsRepository tagsRepository;
	
	public Trs_TagsServiceImpl(Trs_TagsRepository tagsRepository) {
		super();
		this.tagsRepository = tagsRepository;
	}

	@Override
	public Trs_Tags saveTag(Trs_Tags tag) {
		return tagsRepository.save(tag);
	}

	@Override
	public List<Trs_Tags> getAllTags() {
		return tagsRepository.findAll();
	}

	@Override
	public Trs_Tags gelTagById(Trs_Tags tag, long id) {
		return tagsRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Tag", "Id", id));
	}

	@Override
	public Trs_Tags updateTag(Trs_Tags tag, long id) {
		Trs_Tags existingTag = tagsRepository.findById(id).orElseThrow(() -> 
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
