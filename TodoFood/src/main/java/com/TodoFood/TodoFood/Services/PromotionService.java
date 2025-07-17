package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.*;
import com.TodoFood.TodoFood.Repositories.PriceRepository;
import com.TodoFood.TodoFood.Repositories.ProductDetailsRepository;
import com.TodoFood.TodoFood.Repositories.PromotionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService extends BaseService<Promotion> {

    public PromotionService(JpaRepository<Promotion, Long> baseRepository) {
        super(baseRepository);
    }
}

