package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Entities.ProductsDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDetailsService extends BaseService<ProductsDetails>{


    public ProductDetailsService(JpaRepository<ProductsDetails, Long> baseRepository) {
        super(baseRepository);
    }


    // Filtra productos por categoria
    @Transactional
    public List<ProductsDetails>findByCategory(String name) throws Exception {
        try{
            return baseRepository.findAll().stream()
                    .filter(d -> d.getProduct().getCategory().getName().equalsIgnoreCase(name))
                    .toList();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
