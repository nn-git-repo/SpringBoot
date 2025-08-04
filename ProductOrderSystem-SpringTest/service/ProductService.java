package com.example.productorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productorder.entity.Product;
import com.example.productorder.repository.ProductRepository;

@Service
public class ProductService {

	
	   @Autowired
	    private ProductRepository productRepo;

	    public Product addProduct(Product p) {
	        return productRepo.save(p);
	    }

	    public List<Product> getAllProducts() {
	        return productRepo.findAll();
	    }

	    public void updateStock(Long productId, int qty) {
	        Product product = productRepo.findById(productId)
	                 .orElseThrow(() -> new RuntimeException("Product not found"));
	        product.setAvailableQuantity(qty);
	        productRepo.save(product);
	    }
	
	
	
	
}
