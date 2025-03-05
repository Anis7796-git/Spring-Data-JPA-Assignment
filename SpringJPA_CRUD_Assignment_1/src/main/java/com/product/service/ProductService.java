package com.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Interface.I_ProductService;
import com.product.entity.Product;
import com.product.repository.I_ProductRepository;

@Service
public class ProductService implements I_ProductService {

	@Autowired
	private I_ProductRepository prod_service;
	
	
	@Override
	public void insertProduct(Product product) {
		prod_service.save(product);
		System.out.println("ProductService.insertProduct()");
		
	}

	@Override
	public Iterable<Product> getAllProduct() {
		
		return prod_service.findAll();
	}

	@Override
	public Optional<Product> findProductByID(int id) {
		
		return prod_service.findById(id);
	}

	@Override
	public void deleteProductBy(int id) {
		
		Optional<Product> byId = prod_service.findById(id);
		if(byId.isPresent()) {
		prod_service.deleteById(id);

	}else {
		
		System.out.println("Id not found ");
	}
		
	}

}
