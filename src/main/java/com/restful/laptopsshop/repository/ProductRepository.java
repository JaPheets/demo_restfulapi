package com.restful.laptopsshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.laptopsshop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
