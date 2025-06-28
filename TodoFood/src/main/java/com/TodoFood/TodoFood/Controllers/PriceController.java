package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Price;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.PriceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/price")
public class PriceController extends BaseController<Price>{
    public PriceController(PriceService priceService) {
        super(priceService);
    }
}
