package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Commenter;

public interface CommenterService {
	Commenter saveCommenter(Commenter commenter);

	List<Commenter> getAllCommenters();

	Commenter getCommenterById(Commenter commenter, long id);

	Commenter updateCommenter(Commenter commenter, long id);

	void deleteCommenter(long id);

}
