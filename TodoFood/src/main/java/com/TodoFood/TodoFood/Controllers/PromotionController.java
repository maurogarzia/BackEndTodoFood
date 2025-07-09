package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Promotion;
import com.TodoFood.TodoFood.Services.PromotionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/promotion")
public class PromotionController extends BaseController<Promotion>{

    public PromotionController(PromotionService promotionService) {
        super(promotionService);
    }
}
