package com.codegym.repository;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void add(Product product);
    void update(String id, Product product);
    void delete(String id);
    Product findById(String id);
    List<Product> searchName(String name);
}
