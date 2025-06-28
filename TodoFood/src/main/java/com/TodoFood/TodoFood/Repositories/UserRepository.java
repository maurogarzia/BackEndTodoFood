package com.TodoFood.TodoFood.Repositories;

import com.TodoFood.TodoFood.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

}
