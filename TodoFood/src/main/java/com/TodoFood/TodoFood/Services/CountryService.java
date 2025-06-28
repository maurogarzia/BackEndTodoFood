package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseService<Country> {

    public CountryService(JpaRepository<Country, Long> baseRepository) {
        super(baseRepository);
    }
}
