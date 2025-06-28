package com.TodoFood.TodoFood.Repositories;


import com.TodoFood.TodoFood.Entities.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
}
