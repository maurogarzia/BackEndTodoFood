package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BranchesServices extends BaseService<Branches>{

    public BranchesServices(JpaRepository<Branches, Long> baseRepository) {
        super(baseRepository);
    }
}
