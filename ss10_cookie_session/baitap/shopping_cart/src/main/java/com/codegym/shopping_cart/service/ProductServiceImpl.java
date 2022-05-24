package com.codegym.shopping_cart.service;

import com.codegym.shopping_cart.entity.Product;
import com.codegym.shopping_cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean checkId(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public void addProduct(Product product) {

    }


}
