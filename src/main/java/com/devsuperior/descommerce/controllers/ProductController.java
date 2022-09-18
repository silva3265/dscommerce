package com.devsuperior.descommerce.controllers;


import com.devsuperior.descommerce.dto.ProductDTO;
import com.devsuperior.descommerce.entities.Product;
import com.devsuperior.descommerce.repositories.ProductRepository;
import com.devsuperior.descommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products") //Controlador que responde pela /products
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping (value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){ //pra poder casasr com o id
        return service.findById(id);
    }
    
    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }


}
