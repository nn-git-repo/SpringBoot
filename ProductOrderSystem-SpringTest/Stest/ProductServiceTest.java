package com.example.productorder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.productorder.entity.Product;
import com.example.productorder.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	  @Mock
	    private ProductRepository productRepo;

	    @InjectMocks
	    private ProductService productService;

	    @Test
	    void testAddProduct() {
	        Product product = new Product();
	        product.setName("Laptop");
	        product.setPrice(50000);
	        product.setAvailableQuantity(10);

	        when(productRepo.save(product)).thenReturn(product);

	        Product savedProduct = productService.addProduct(product);
	        assertEquals("Laptop", savedProduct.getName());
	    }

	    @Test
	    void testUpdateStock() {
	        Product product = new Product();
	        product.setProductId(1L);
	        product.setAvailableQuantity(10);

	        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

	        productService.updateStock(1L, 5);

	        verify(productRepo).save(product);
	        assertEquals(5, product.getAvailableQuantity());
	    }
	
	
	
}
