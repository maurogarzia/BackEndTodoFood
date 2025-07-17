package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.PromotionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PromotionDetailsService extends BaseService<PromotionDetails>{

    public PromotionDetailsService(JpaRepository<PromotionDetails, Long> baseRepository) {
        super(baseRepository);
    }

}
