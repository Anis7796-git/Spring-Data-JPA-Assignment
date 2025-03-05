package com.anhee.repository;

import org.springframework.data.repository.CrudRepository;

import com.anhee.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
