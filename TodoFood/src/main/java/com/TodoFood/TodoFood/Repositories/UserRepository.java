package com.TodoFood.TodoFood.Repositories;

import com.TodoFood.TodoFood.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByUserName(String username);

}
