package com.restful.laptopsshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.laptopsshop.domain.Product;
import com.restful.laptopsshop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getHelloWorld() {
        log.info("run Hello");
        return "Hello";
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product createProduct) {
        Product postProduct = this.productService.handleCreateProduct(createProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(postProduct);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        this.productService.handleDeleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Product");
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Product getProductById = this.productService.fetchProductById(id);
        return ResponseEntity.ok(getProductById);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(this.productService.fetchAllProducts());

    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product updateProduct) {
        Product putProduct = this.productService.handleUpdateProduct(updateProduct);
        return ResponseEntity.ok(putProduct);
    }
}
