package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.User;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/user")
public class UserController extends BaseController<User>{
    public UserController(BaseService<User> baseService) {
        super(baseService);
    }
}
