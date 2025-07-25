package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.UnitaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitaryDetailsService extends BaseService<UnitaryDetails>{

    public UnitaryDetailsService(JpaRepository<UnitaryDetails, Long> baseRepository) {
        super(baseRepository);
    }
}
