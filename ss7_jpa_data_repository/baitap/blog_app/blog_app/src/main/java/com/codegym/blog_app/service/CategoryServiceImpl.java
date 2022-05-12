package com.codegym.blog_app.service;

import com.codegym.blog_app.entity.Category;
import com.codegym.blog_app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> findAllByNativeQuery() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAllByNativeQuery().forEach(p -> categories.add(p));
		return categories;
	}

	@Override
	public void create(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void update(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category findById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}
}
