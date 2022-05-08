package com.codegym.service;

import com.codegym.entity.Blog;
import com.codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;


    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        blogRepository.findAll().forEach(b -> blogs.add(b));
        return blogs;
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }


    @Override
    public void delete(int id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog!=null){
            blogRepository.delete(blog);
        }
    }
}