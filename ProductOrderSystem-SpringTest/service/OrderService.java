package com.example.productorder.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productorder.entity.Order;
import com.example.productorder.entity.Product;
import com.example.productorder.repository.OrderRepository;
import com.example.productorder.repository.ProductRepository;

@Service

public class OrderService {
	   @Autowired
	    private OrderRepository orderRepo;

	    @Autowired
	    private ProductRepository productRepo;

	    public Order placeOrder(Long productId, int quantity) {
	        Product product = productRepo.findById(productId)
	                 .orElseThrow(() -> new RuntimeException("Product not found"));

	        if (product.getAvailableQuantity() < quantity) {
	            throw new RuntimeException("Insufficient Stock");
	        }

	        Order order = new Order();
	        order.setProduct(product);
	        order.setOrderDate(LocalDate.now());
	        order.setQuantityOrdered(quantity);

	        product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
	        productRepo.save(product);

	        return orderRepo.save(order);
	    }

	    public List<Order> getAllOrders() {
	        return orderRepo.findAll();
	    }
	
	
}
