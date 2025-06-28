package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address> {

    public AddressService(JpaRepository<Address, Long> baseRepository) {
        super(baseRepository);
    }

}
