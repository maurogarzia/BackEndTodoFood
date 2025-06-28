package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BillDetailsService extends BaseService<BillDetails> {

    public BillDetailsService(JpaRepository<BillDetails, Long> baseRepository) {
        super(baseRepository);
    }
}
