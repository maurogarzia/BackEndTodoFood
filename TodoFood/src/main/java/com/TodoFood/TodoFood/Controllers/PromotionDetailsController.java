package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Promotion;
import com.TodoFood.TodoFood.Entities.PromotionDetails;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.PromotionDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/promotion-details")
public class PromotionDetailsController extends BaseController<PromotionDetails>{

    public PromotionDetailsController(PromotionDetailsService promotionDetailsService) {
        super(promotionDetailsService);
    }
}
