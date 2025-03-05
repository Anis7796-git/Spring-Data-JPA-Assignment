package com.product.Interface;

import java.util.Optional;

import com.product.entity.Product;

public interface I_ProductService {
	
	void insertProduct(Product product);
	Iterable<Product> getAllProduct();
	Optional<Product> findProductByID(int id);
	void deleteProductBy(int id);
	
}
