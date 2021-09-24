package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Trs_Blog;
import com.backend.source.repository.Trs_BlogRepository;
import com.backend.source.service.Trs_BlogService;

@Service
public class Trs_BlogServiceImpl implements Trs_BlogService{

	Trs_BlogRepository blogRepository;
	
	public Trs_BlogServiceImpl(Trs_BlogRepository blogRepository) {
		super();
		this.blogRepository = blogRepository;
	}
	
	
	@Override
	public Trs_Blog saveBlog(Trs_Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public List<Trs_Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	@Override
	public Trs_Blog gelBlogById(Trs_Blog blog, long id) {
		return blogRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Blog","Id",id));
	}

	@Override
	public Trs_Blog updateBlog(Trs_Blog blog, long id) {
		Trs_Blog existingBlog = blogRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Blog","Id",id));
		existingBlog.setBlogContent(blog.getBlogContent());
		existingBlog.setTitle(blog.getTitle());
		blogRepository.save(existingBlog);
		
		return existingBlog;
	}

	@Override
	public void deleteBlog(long id) {
		 blogRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Blog","Id",id));
		 blogRepository.deleteById(id);
	}

}
