package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Address;
import com.TodoFood.TodoFood.Services.AddressService;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/address")
public class AddressController extends BaseController<Address>{

    public AddressController(AddressService addressService) {
        super(addressService);
    }
}
