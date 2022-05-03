package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void add(Product product);
    void update(String id, Product product);
    void delete(String id);
    Product findById(String id);
    List<Product> searchName(String name);
}
