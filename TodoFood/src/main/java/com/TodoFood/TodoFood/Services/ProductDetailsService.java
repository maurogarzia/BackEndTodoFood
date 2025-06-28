package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Entities.ProductsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsService extends BaseService<ProductsDetails>{


    public ProductDetailsService(JpaRepository<ProductsDetails, Long> baseRepository) {
        super(baseRepository);
    }
}
