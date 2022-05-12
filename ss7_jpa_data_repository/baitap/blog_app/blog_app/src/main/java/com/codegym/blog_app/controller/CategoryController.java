package com.codegym.blog_app.controller;

import com.codegym.blog_app.entity.Blog;
import com.codegym.blog_app.entity.Category;
import com.codegym.blog_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("list")
	public String showListCustomer(Model model) {
		List<Category> categories = categoryService.findAllByNativeQuery();
		model.addAttribute("categories", categories);
		return "category/list";
	}

	@GetMapping("create")
	public String create(Model model){
		Category category = new Category();
		model.addAttribute("category", category);
		return "category/create";
	}
	@PostMapping("create")
	public String create(@ModelAttribute("category") Category category, Model model){
		categoryService.create(category);
		return "redirect:/category/list";
	}

	@GetMapping("/delete/{id}")
	public String showDelete(@PathVariable("id") int id, Model model) {
		Blog blog = new Blog();
		model.addAttribute("category", categoryService.findById(id));
		return "category/delete";
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute("blog") Blog blog){
		categoryService.delete(blog.getId());
		return "redirect:/category/list";
	}

	@GetMapping("/update/{id}")
	public String showUpdate(@PathVariable("id") int id, Model model) {
		Category category = new Category();
		model.addAttribute("category", categoryService.findById(id));
		return "category/update";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute("blog") Category category){
		categoryService.update(category);
		return "redirect:/blog/list";
	}
}
