package com.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.product.Interface.I_ProductService;
import com.product.entity.Product;
import com.product.service.ProductService;
@Controller
public class ProductController {
	
//private	ProductService ps
	@Autowired
	private I_ProductService ps;
	public void insertProduct(Product product){
		ps.insertProduct(product);
		
	}
	
	public void retrieveAllProducts() {
		
		Iterable<Product> allProduct = ps.getAllProduct();
		
		allProduct.forEach(System.out::println);
		
		
		
		}
	public Product findProductById(int id) {
		
		Optional<Product> pd = ps.findProductByID(id);
	
		if(pd.isPresent()) {
			Product product = pd.get();
		return product;
		}
		return new Product("Default product ","product not found",0000.0);
	}
	
	public void deleteProductById(int id) {
		
	
		ps.deleteProductBy(id);
		
	}

}
