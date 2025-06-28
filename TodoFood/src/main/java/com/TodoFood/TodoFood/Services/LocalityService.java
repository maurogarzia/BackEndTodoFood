package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalityService extends BaseService<Locality>{

    public LocalityService(JpaRepository<Locality, Long> baseRepository) {
        super(baseRepository);
    }
}
