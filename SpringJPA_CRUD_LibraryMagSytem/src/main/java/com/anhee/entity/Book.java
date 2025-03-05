package com.anhee.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Lab_Book")
@NoArgsConstructor
public class Book {
	
	
	public Book(String title, String author, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Id
	@Column(name="BOOK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="PRICE")
	private Double price;
	 
	 
}
