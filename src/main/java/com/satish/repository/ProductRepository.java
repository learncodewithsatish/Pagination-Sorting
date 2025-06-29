package com.satish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satish.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
