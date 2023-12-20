package com.example.product.controller;

import com.example.product.dto.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable Integer id){
        if(productService.findById(id) != null){
            productService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        if(productService.findById(id) != null){
            Product product = productService.findById(id).orElse(null);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> findAll(){
        Iterable<Product> products = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id,@RequestBody Product product){
        if (productService.findById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            productService.update(id, product);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
    }

}
