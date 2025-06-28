package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/todoFood/product")
public class ProductController extends BaseController<Products>{
    public ProductController(BaseService<Products> baseService) {
        super(baseService);
    }
}
