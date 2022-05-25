package com.codegym.blog_app.service;

import com.codegym.blog_app.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
	List<Blog> getList();
	void create(Blog blog);
	void update(Blog blog);
	void  delete(int id);
	Blog findById(int id);
	Page<Blog> findAllByNativeQuery(String author, String category, Pageable pageable);

	List<Blog> findAllByCategory_Id(Integer id);

}
