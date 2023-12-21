package com.example.product.service;

import com.example.product.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void save(Product product);

    void deleteById(Integer id);

    Optional<Product> findById(Integer id);

    Iterable<Product> findAll();

    Product update(Integer id,Product product);
}
