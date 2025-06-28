package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Country;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.CountryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/country")
public class CountryController extends BaseController<Country>{
    public CountryController(CountryService countryService) {
        super(countryService);
    }
}
