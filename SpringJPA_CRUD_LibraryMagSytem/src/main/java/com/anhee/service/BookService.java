package com.anhee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anhee.entity.Book;
import com.anhee.inter.IBookService;
import com.anhee.repository.BookRepository;


@Component
public class BookService implements IBookService{
	
	
	@Autowired
	private BookRepository  bookrepo;
	
	@Override
	public void addBook(Book book) {
		bookrepo.save(book);
		
	}

	@Override
	public Iterable<Book> getAllBooks() {
		
		return bookrepo.findAll();
	}

	@Override
	public Optional<Book> findBookById(Integer id) {
		Optional<Book> opt = bookrepo.findById(id);
		if(opt.isPresent()) {
			return opt;
			}else {
			return null;
			}
		
		
	}

	@Override
	public void deleteBookById(Integer id) {
		
		Optional<Book> opt= bookrepo.findById(id);
		if(opt.isPresent()) {
			bookrepo.deleteById(id);
			System.out.println("Book Deleted .....");
			
		}
		else {
			System.out.println("Book not found ");
		}
	}

	

}
