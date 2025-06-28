package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService extends BaseService<Bill> {

    public BillService(JpaRepository<Bill, Long> baseRepository) {
        super(baseRepository);
    }
}
