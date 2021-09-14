package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Org_Blog;

public interface BlogService {
	Org_Blog saveBlog(Org_Blog blog);

	List<Org_Blog> getAllBlogs();

	Org_Blog gelBlogById(Org_Blog blog, long id);

	Org_Blog updateBlog(Org_Blog blog,long id);

	void deleteBlog(long id);

}
