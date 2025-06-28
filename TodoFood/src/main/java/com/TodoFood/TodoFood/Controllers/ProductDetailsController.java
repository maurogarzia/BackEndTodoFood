package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Entities.ProductsDetails;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.ProductDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/product-details")
public class ProductDetailsController extends BaseController<ProductsDetails>{

    public ProductDetailsController(ProductDetailsService productDetailsService) {
        super(productDetailsService);
    }
}
