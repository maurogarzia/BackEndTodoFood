package com.TodoFood.TodoFood.Repositories;

import com.TodoFood.TodoFood.Entities.Products;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Products, Long>{
}
