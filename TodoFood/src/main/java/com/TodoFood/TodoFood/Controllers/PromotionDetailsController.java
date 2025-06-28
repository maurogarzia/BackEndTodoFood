package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Promotion;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/promotion-details")
public class PromotionDetailsController extends BaseController<Promotion>{
    public PromotionDetailsController(BaseService<Promotion> baseService) {
        super(baseService);
    }
}
