package com.example.productorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productorder.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
