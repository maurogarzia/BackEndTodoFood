package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PriceService extends BaseService<Price>{

    public PriceService(JpaRepository<Price, Long> baseRepository) {
        super(baseRepository);
    }
}
