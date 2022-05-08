package com.codegym.service;

import com.codegym.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id);
    Blog findById(int id);
}
