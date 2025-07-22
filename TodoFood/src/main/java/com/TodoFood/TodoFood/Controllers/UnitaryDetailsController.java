package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.UnitaryDetails;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.UnitaryDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/unitary_details")
public class UnitaryDetailsController extends BaseController<UnitaryDetails>{
    public UnitaryDetailsController(UnitaryDetailsService unitaryDetailsService) {
        super(unitaryDetailsService);
    }
}
