package com.anhee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.anhee.entity.Book;
import com.anhee.inter.IBookService;

@Controller
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	public void addBook(Book book)
	{
		bookService.addBook(book);
		
	}
	public Iterable<Book> retrieveAllBooks()
	{
		return bookService.getAllBooks();
		
	}
	public Optional<Book> findBookById(Integer id)
	{
		Optional<Book> bookById = bookService.findBookById(id);
		
		return bookById;
	}
	public void deleteBookById(Integer id){
		
		bookService.deleteBookById(id);
		
		
		
		
	}

}
