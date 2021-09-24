package com.backend.source.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.source.exception.ResourceNotFoundException;
import com.backend.source.model.Org_Blog;
import com.backend.source.repository.Org_BlogRepository;
import com.backend.source.service.Org_BlogService;

@Service
public class Org_BlogServiceImpl implements Org_BlogService{

	Org_BlogRepository blogRepository;
	
	public Org_BlogServiceImpl(Org_BlogRepository blogRepository) {
		super();
		this.blogRepository = blogRepository;
	}
	
	
	@Override
	public Org_Blog saveBlog(Org_Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public List<Org_Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	@Override
	public Org_Blog gelBlogById(Org_Blog blog, long id) {
		return blogRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Blog","Id",id));
	}

	@Override
	public Org_Blog updateBlog(Org_Blog blog, long id) {
		Org_Blog existingBlog = blogRepository.findById(id).orElseThrow(() -> 
														new ResourceNotFoundException("Blog","Id",id));
		
		existingBlog.setDate(blog.getDate());
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
