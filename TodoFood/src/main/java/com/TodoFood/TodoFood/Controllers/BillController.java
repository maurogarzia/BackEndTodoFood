package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Bill;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/bill")
public class BillController extends BaseController<Bill>{

    public BillController(BaseService<Bill> baseService) {
        super(baseService);
    }
}
