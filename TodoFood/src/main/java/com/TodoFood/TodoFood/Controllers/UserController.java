package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.User;
import com.TodoFood.TodoFood.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/todoFood/user")
public class UserController extends BaseController<User>{

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        super(userService);
    }

    @GetMapping("/username/{username}")
    public User getByUsername(@PathVariable String username) throws Exception {
        return userService.findByUsername(username);
    }

}
