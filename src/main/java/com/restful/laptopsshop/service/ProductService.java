package com.restful.laptopsshop.service;

import org.springframework.stereotype.Service;

import com.restful.laptopsshop.domain.Product;
import com.restful.laptopsshop.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handleCreateProduct(Product product) {

        return this.productRepository.save(product);
    }

    public void handleDeleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    public List<Product> fetchAllProducts() {
        return this.productRepository.findAll();
    }

    public Product fetchProductById(long id) {
        Optional<Product> producOptional = this.productRepository.findById(id);
        if (producOptional.isPresent()) {
            return producOptional.get();
        }
        return null;
    }

    public Product handleUpdateProduct(Product putProduct) {
        Product currenProduct = this.fetchProductById(putProduct.getId());
        if (currenProduct != null) {
            currenProduct.setName(putProduct.getName());
            currenProduct.setPrice(putProduct.getPrice());
            currenProduct.setQuantity(putProduct.getQuantity());

            currenProduct = this.productRepository.save(currenProduct);
        }
        return currenProduct;
    }
}
