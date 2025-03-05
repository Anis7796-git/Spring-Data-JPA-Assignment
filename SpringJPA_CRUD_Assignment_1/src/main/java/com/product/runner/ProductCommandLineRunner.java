package com.product.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.product.controller.ProductController;
import com.product.entity.Product;
@Component
public class ProductCommandLineRunner implements CommandLineRunner{
	 public static final String RESET = "\u001B[0m";
	 public static final String CYAN = "\u001B[36m";
	 public static final String BLUE = "\u001B[34m";
	@Autowired
	private ProductController productController;
	@Override
	public void run(String... args) throws Exception {
	
		//productController.insertProduct(new Product("fan","table fan",1200.0));
		Product productById = productController.findProductById(1);
		System.out.println(BLUE+" =================================================== ============= "+RESET);
		System.out.println(CYAN+"Product Id"+productById.getProductId()+"Product Name"+productById.getProductName()+" : Product Description "+productById.getDescription()+" : product Price"+productById.getPrice()+RESET);
		System.out.println(BLUE+" =================================================== ============= "+RESET);
		productController.retrieveAllProducts();
		System.out.println(BLUE+" =================================================== ============= "+RESET);
		
		System.out.println(CYAN);
		productController.deleteProductById(1);
		System.out.println(RESET);
		
		
		System.out.println(BLUE+" ===========================================================");
		
		

		
		
	
	}

}
