package com.devsuperior.descommerce.services;


import com.devsuperior.descommerce.dto.ProductDTO;
import com.devsuperior.descommerce.entities.Product;
import com.devsuperior.descommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);

    }
}
