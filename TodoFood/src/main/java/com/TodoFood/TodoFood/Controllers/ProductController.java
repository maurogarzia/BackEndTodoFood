package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.ProductsService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/todoFood/product")
public class ProductController extends BaseController<Products>{
    public ProductController(ProductsService productsService) {
        super(productsService);
    }
}
