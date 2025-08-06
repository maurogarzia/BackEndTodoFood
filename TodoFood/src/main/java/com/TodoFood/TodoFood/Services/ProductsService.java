package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Entities.ProductsDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService extends BaseService<Products>{

    public ProductsService(JpaRepository<Products, Long> baseRepository) {
        super(baseRepository);
    }

    // Filtra productos por categoria
    @Transactional
    public List<Products> findByCategory(String name) throws Exception {
        try{
            return baseRepository.findAll().stream()
                    .filter(d -> d.getCategory().getName().equalsIgnoreCase(name))
                    .toList();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
