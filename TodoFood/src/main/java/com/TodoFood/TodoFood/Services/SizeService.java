package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SizeService extends BaseService<Size>{

    public SizeService(JpaRepository<Size, Long> baseRepository) {
        super(baseRepository);
    }
}
