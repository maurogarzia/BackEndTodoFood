package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Bill;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.BillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/bill")
public class BillController extends BaseController<Bill>{

    public BillController(BillService billService) {
        super(billService);
    }
}
