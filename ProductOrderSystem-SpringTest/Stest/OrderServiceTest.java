package com.example.productorder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.productorder.entity.Order;
import com.example.productorder.entity.Product;
import com.example.productorder.repository.OrderRepository;
import com.example.productorder.repository.ProductRepository;
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	@Mock
    private OrderRepository orderRepo;

    @Mock
    private ProductRepository productRepo;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testPlaceOrderSuccess() {
        Product product = new Product();
        product.setProductId(1L);
        product.setAvailableQuantity(10);

        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        Order order = new Order();
        when(orderRepo.save(any(Order.class))).thenReturn(order);

        Order placedOrder = orderService.placeOrder(1L, 5);

        assertNotNull(placedOrder);
        assertEquals(5, product.getAvailableQuantity());
    }

    @Test
    void testPlaceOrderInsufficientStock() {
        Product product = new Product();
        product.setProductId(1L);
        product.setAvailableQuantity(3);

        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        assertThrows(RuntimeException.class, () -> {
            orderService.placeOrder(1L, 5);
        });
    }
	
	
	
}
