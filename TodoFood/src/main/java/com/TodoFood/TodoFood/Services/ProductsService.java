package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductsService extends BaseService<Products>{

    public ProductsService(JpaRepository<Products, Long> baseRepository) {
        super(baseRepository);
    }
}
