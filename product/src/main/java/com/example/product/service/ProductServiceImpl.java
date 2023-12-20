package com.example.product.service;

import com.example.product.dto.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) {
        product.setCreatedate(new Date());
        productRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void update(Integer id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
           if(optionalProduct.isPresent()){
              Product updateProduct = optionalProduct.get();
              updateProduct.setName(product.getName());
              updateProduct.setPrice(product.getPrice());
              updateProduct.setCreatedate(product.getCreatedate());
              updateProduct.setStatus(product.isStatus());
              updateProduct.setCreatedate(new Date());
        }
    }

}
