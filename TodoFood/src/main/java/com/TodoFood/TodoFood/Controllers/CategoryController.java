package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Category;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/category")

public class CategoryController extends BaseController<Category>{
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }
}
