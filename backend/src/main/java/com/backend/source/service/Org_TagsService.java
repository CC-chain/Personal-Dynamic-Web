package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Org_Tags;

public interface Org_TagsService {
	Org_Tags saveTag(Org_Tags tag);

	List<Org_Tags> getAllTags();

	Org_Tags gelTagById(Org_Tags tag, long id);

	Org_Tags updateTag(Org_Tags tag, long id);

	void deleteTag(long id);

}
