package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.BillDetails;

import com.TodoFood.TodoFood.Services.BillDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/bill-details")
public class BillDetailsController extends BaseController<BillDetails>{

    public BillDetailsController(BillDetailsService billDetailsService) {
        super(billDetailsService);
    }
}
