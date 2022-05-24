package com.codegym.shopping_cart.service;

import com.codegym.shopping_cart.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);

    Boolean checkId(Long id);

    void addProduct(Product product);
}
