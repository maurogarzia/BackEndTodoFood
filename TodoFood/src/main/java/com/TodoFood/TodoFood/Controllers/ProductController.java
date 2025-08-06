package com.TodoFood.TodoFood.Controllers;
import com.TodoFood.TodoFood.Entities.Products;
import com.TodoFood.TodoFood.Entities.ProductsDetails;
import com.TodoFood.TodoFood.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todoFood/product")
public class ProductController extends BaseController<Products>{

    @Autowired
    public ProductsService productsService;

    public ProductController(ProductsService productsService) {
        super(productsService);
    }

    // Filtra productos por categoria
    @GetMapping("/by-category")
    public ResponseEntity<List<Products>> getByCategoryName(@RequestParam String name) throws Exception{
        List<Products> details = productsService.findByCategory(name);
        return ResponseEntity.ok(details);
    }
}
