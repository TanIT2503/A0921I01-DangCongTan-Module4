package com.codegym.blog_app.controller;

import com.codegym.blog_app.entity.Blog;
import com.codegym.blog_app.entity.Category;
import com.codegym.blog_app.service.BlogService;
import com.codegym.blog_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;
    @GetMapping("/category")
    public ResponseEntity<List<Category>> listAllCategory(){
        List<Category> categoryList = categoryService.findAllByNativeQuery();
        if(categoryList.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categoryList,HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> listAllBlog(){
        List<Blog> blogs = blogService.getList();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }

    @GetMapping("/blog/view/{id}")
    public ResponseEntity<List<Blog>> listAllBlogWithCategory(@PathVariable("id") Integer id){
        List<Blog> blog = blogService.findAllByCategory_Id(id);
        if(blog.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blog,HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findBlog(@PathVariable("id") Integer id){
        Blog blog = blogService.findById(id);
        if(blog==null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }

    @GetMapping("/blogs/searchAuthor")
    public ResponseEntity<List<Blog>> findBlogByAuthor(@RequestParam("nameAuthor") String author){
        List<Blog> blogs = blogService.findAllByAuthorContains(author);
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }
}
