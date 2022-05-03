package com.codegym.repository;

import com.codegym.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private static Map<String, Product> productMap = new HashMap<>();

    static {
        productMap.put("1", new Product("1", "MSI GS66 VN245", 45900000, "Intel Core I7 11950H, 16GB Ram, 1TB SSD", "MSI"));
        productMap.put("2", new Product("2", "Surface Laptop Studio", 84590000, "Intel Core I9 11980H, 32GB Ram, 1TB SSD", "Microsoft"));
        productMap.put("3", new Product("3", "Samsung Galaxy Book Pro 2021", 31200000, "Intel Core I5 1135G7, 8GB Ram, 254TB SSD", "SamSung"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void add(Product product) {
        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public void update(String id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(String id) {
        if (productMap.containsKey(id)) {
            productMap.remove(id);
        }
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> products = new ArrayList<>();
        for(Product product : productMap.values()){
            if (product.getProductName().equals(name))
                products.add(product);
        }
        return products;
    }
}
