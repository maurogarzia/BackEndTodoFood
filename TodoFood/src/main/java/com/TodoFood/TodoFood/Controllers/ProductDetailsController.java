package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/product-details")
public class ProductDetailsController extends BaseController<Products>{
    public ProductDetailsController(BaseService<Products> baseService) {
        super(baseService);
    }
}
