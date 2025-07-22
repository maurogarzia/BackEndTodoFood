package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PromotionService extends BaseService<Promotion> {

    public PromotionService(JpaRepository<Promotion, Long> baseRepository) {
        super(baseRepository);
    }
}

