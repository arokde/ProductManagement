package com.rocketsoftware.product.controllers;


import com.rocketsoftware.product.models.Product;
import com.rocketsoftware.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> list() {
        final List<Product> products = productRepository.findAll();
        return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") long id) {
        return productRepository.getOne(id);
    }

}
