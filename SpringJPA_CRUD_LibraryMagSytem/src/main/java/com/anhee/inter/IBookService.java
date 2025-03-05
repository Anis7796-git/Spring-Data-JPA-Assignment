package com.anhee.inter;

import java.util.Optional;

import com.anhee.entity.Book;

public interface IBookService {
	void addBook(Book book);
	Iterable<Book> getAllBooks();
	//Optional<Book> findBookById(Long id);
	void deleteBookById(Integer id);
	Optional<Book> findBookById(Integer id);
}
