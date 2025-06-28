package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Locality;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/locality")
public class LocalityController extends BaseController<Locality>{
    public LocalityController(BaseService<Locality> baseService) {
        super(baseService);
    }
}
