package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Trs_Tags;


public interface Trs_TagsService {
	Trs_Tags saveTag(Trs_Tags tag);

	List<Trs_Tags> getAllTags();

	Trs_Tags gelTagById(Trs_Tags tag, long id);

	Trs_Tags updateTag(Trs_Tags tag, long id);

	void deleteTag(long id);

}
