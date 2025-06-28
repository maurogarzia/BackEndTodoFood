package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService extends BaseService<Province>{

    public ProvinceService(JpaRepository<Province, Long> baseRepository) {
        super(baseRepository);
    }
}
