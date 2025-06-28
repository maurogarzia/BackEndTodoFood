package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Promotion;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/todoFood/promotion")
public class PromotionController extends BaseController<Promotion>{
    public PromotionController(BaseService<Promotion> baseService) {
        super(baseService);
    }
}
