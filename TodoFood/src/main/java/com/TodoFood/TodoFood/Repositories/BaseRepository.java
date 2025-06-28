package com.TodoFood.TodoFood.Repositories;

import com.TodoFood.TodoFood.Entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
}
