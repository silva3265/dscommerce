package com.devsuperior.descommerce.controllers;


import com.devsuperior.descommerce.dto.ProductDTO;
import com.devsuperior.descommerce.entities.Product;
import com.devsuperior.descommerce.repositories.ProductRepository;
import com.devsuperior.descommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products") //Controlador que responde pela /products
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping (value = "/{id}")

    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){ //pra poder casasr com o id
        ProductDTO dto =  service.findById(id);
        return  ResponseEntity.ok(dto);
    }
    
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){
        Page<ProductDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
    @PostMapping
    public ResponseEntity <ProductDTO> insert (@RequestBody ProductDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }



}
