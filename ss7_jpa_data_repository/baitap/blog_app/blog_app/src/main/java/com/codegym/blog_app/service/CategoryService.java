package com.codegym.blog_app.service;

import com.codegym.blog_app.entity.Category;

import java.util.List;

public interface CategoryService {
	List<Category> findAllByNativeQuery();
	void create(Category category);
	void  delete(int id);

	void update(Category category);
	Category findById(int id);
}
