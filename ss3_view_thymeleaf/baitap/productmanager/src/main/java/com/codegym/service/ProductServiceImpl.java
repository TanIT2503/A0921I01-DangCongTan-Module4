package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void update(String id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> searchName(String name) {
        return productRepository.searchName(name);
    }
}
