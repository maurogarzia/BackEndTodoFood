package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category>{

    public CategoryService(JpaRepository<Category, Long> baseRepository) {
        super(baseRepository);
    }
}
