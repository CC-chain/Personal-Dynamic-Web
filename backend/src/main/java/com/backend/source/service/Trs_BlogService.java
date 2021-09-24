package com.backend.source.service;

import java.util.List;

import com.backend.source.model.Trs_Blog;


public interface Trs_BlogService {
	Trs_Blog saveBlog(Trs_Blog blog);

	List<Trs_Blog> getAllBlogs();

	Trs_Blog gelBlogById(Trs_Blog blog, long id);

	Trs_Blog updateBlog(Trs_Blog blog,long id);

	void deleteBlog(long id);

}
