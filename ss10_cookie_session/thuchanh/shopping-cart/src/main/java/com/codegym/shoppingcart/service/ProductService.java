package com.codegym.shoppingcart.service;

import com.codegym.shoppingcart.entity.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
