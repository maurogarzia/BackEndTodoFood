package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Size;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/size")
public class SizeController extends BaseController<Size>{
    public SizeController(BaseService<Size> baseService) {
        super(baseService);
    }
}
