package com.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.product.entity.Product;

public interface I_ProductRepository extends CrudRepository<Product, Integer> {

}
