package com.devsuperior.descommerce.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.descommerce.dto.ProductDTO;
import com.devsuperior.descommerce.entities.Product;
import com.devsuperior.descommerce.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);

    }
    //Metodo de serviço que busca todos os produtos
    @Transactional(readOnly = true)
    public Page <ProductDTO> findAll(Pageable pageable){
        Page<Product> result = repository.findAll(pageable); //busca todos os produtos do banco de dados
        return result.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){

        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity = repository.save(entity);

        return new ProductDTO(entity);

    }
}
