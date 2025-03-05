package com.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Product_67")
@Data
@NoArgsConstructor

public class Product {
	
	

	public Product(String productName, String description, Double price) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
	}

	@Id
	@Column(name="Prod_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
		
		@Column(name="PROD_NAME")
		private String productName;
			
		@Column(name="DESCRIPTION")
		private String	description;

		@Column(name="PRICE")
		private Double price;
		
		
}
