package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Entities.ProductsDetails;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todoFood/product-details")
public class ProductDetailsController extends BaseController<ProductsDetails>{

    @Autowired
    public ProductDetailsService productDetailsService;

    public ProductDetailsController(ProductDetailsService productDetailsService) {
        super(productDetailsService);

    }

    // Filtra productos por categoria
    @GetMapping("/by-category")
    public ResponseEntity<List<ProductsDetails>> getByCategoryName(@RequestParam String name) throws Exception{
        List<ProductsDetails> details = productDetailsService.findByCategory(name);
        return ResponseEntity.ok(details);
    }
}
