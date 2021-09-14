package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Commenter;
import com.backend.source.model.Org_Abilities;
import com.backend.source.repository.CommenterRepository;
import com.backend.source.service.CommenterService;

@Service
public class CommenterServiceImpl implements CommenterService{

	CommenterRepository commenterRepository;
	
	public CommenterServiceImpl(CommenterRepository commenterRepository) {
		super();
		this.commenterRepository = commenterRepository;
	}
	
	@Override
	public Commenter saveCommenter(Commenter commenter) {
		return  commenterRepository.save(commenter);
	}

	@Override
	public List<Commenter> getAllCommenters() {
		return commenterRepository.findAll();
	}

	@Override
	public Commenter getCommenterById(Commenter commenter, long id) {
		return commenterRepository.findById(id).orElseThrow(() -> 
															new ResourceNotFoundException("Commenter","Id",id));
	}

	@Override
	public Commenter updateCommenter(Commenter commenter, long id) {
		Commenter existingCommenter = commenterRepository.findById(id).orElseThrow(() -> 
															new ResourceNotFoundException("Commenter","Id",id)); 
		
		existingCommenter.setComment(commenter.getComment());
		existingCommenter.setDate(commenter.getDate());
		existingCommenter.setEmail(commenter.getEmail());
		existingCommenter.setName(commenter.getName());
		commenterRepository.save(existingCommenter);
		
		return existingCommenter;
	}

	@Override
	public void deleteCommenter(long id) {
		commenterRepository.findById(id).orElseThrow(() -> 
															new ResourceNotFoundException("Commenter","Id",id)); 
		commenterRepository.deleteById(id);
	}

}
