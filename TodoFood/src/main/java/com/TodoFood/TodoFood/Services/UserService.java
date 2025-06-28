package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{

    public UserService(JpaRepository<User, Long> baseRepository) {
        super(baseRepository);
    }
}
