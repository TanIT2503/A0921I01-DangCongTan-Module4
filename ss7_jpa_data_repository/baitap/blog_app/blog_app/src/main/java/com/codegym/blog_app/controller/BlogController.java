package com.codegym.blog_app.controller;


import com.codegym.blog_app.entity.Blog;
import com.codegym.blog_app.entity.Category;
import com.codegym.blog_app.repository.CategoryRepository;
import com.codegym.blog_app.service.BlogService;
import com.codegym.blog_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogService blogService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	private CategoryRepository categoryRepository;

	@ModelAttribute("categories")
	public List<Category> setCategory(){
		List<Category> categories = categoryRepository.findAllByNativeQuery();
		return categories;
	}
	@GetMapping("list")
	public String showListCustomer(
			@RequestParam(defaultValue = "") String key_author,
			@RequestParam(defaultValue = "") String key_category
			,@PageableDefault(size = 5) Pageable pageable
			, Model model) {
		Page<Blog> blogs = blogService.findAllByNativeQuery(key_author, key_category, pageable);
		model.addAttribute("blogs", blogs);
		model.addAttribute("key_author", key_author);
		model.addAttribute("key_category", key_category);
		return "blog/list";
	}

	@GetMapping("create")
	public String create(Model model){
		Blog blog = new Blog();
		blog.setCategory(new Category());
		model.addAttribute("blog", blog);
		model.addAttribute("category", categoryService.findAllByNativeQuery());
		return "blog/create";
	}
	@PostMapping("create")
	public String create(@ModelAttribute("blog") Blog blog, Model model){
		blogService.create(blog);
		return "redirect:/blog/list";
	}

	@GetMapping("/update/{id}")
	public String showUpdate(@PathVariable("id") int id, Model model) {
		Blog blog = new Blog();
		blog.setCategory(new Category());
		model.addAttribute("category", categoryService.findAllByNativeQuery());
		model.addAttribute("blog", blogService.findById(id));
		return "blog/update";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute("blog") Blog blog){
		blogService.update(blog);
		return "redirect:/blog/list";
	}
//	@GetMapping("/delete/{id}")
//	public String showDelete(@PathVariable("id") int id, Model model) {
//		Blog blog = new Blog();
//		blog.setCategory(new Category());
//		model.addAttribute("category", categoryService.findAllByNativeQuery());
//		model.addAttribute("blog", blogService.findById(id));
//		return "blog/delete";
//	}

	@PostMapping("/delete")
	public String delete(@RequestParam("blogId") int id){
		blogService.delete(id);
		return "redirect:/blog/list";
	}
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model){
		Blog blog = blogService.findById(id);
		model.addAttribute("blog",blog);
		return "/blog/view";
	}
}
