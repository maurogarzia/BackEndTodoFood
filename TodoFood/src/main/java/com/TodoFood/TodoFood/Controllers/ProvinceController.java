package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Province;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.ProvinceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/province")
public class ProvinceController extends BaseController<Province>{
    public ProvinceController(ProvinceService provinceService) {
        super(provinceService);
    }
}
