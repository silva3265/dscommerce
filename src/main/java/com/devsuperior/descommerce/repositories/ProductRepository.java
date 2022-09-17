package com.devsuperior.descommerce.repositories;

import com.devsuperior.descommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
