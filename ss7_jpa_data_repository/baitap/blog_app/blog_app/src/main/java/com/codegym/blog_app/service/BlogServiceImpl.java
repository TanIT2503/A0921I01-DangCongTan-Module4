package com.codegym.blog_app.service;

import com.codegym.blog_app.entity.Blog;
import com.codegym.blog_app.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
	@Autowired
	private BlogRepository blogRepository;

	@Override
	public List<Blog> getList() {
		List<Blog> blogs = new ArrayList<>();
		blogRepository.findAll().forEach(c -> blogs.add(c));
		return blogs;
	}

	@Override
	public void create(Blog blog) {
		blogRepository.save(blog);
	}

	@Override
	public void update(Blog blog) {
		blogRepository.save(blog);
	}

	@Override
	public void delete(int id) {
		blogRepository.deleteById(id);
	}

	@Override
	public Blog findById(int id) {
		return blogRepository.findById(id).orElse(null);
	}

	@Override
	public Page<Blog> findAllByNativeQuery(String author, String category,Pageable pageable) {
		return blogRepository.findAllByNativeQuery(author, category, pageable);
	}


}
