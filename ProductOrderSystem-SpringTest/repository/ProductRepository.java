package com.example.productorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productorder.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
