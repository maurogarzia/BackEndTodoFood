package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BranchesRepository extends BaseService<Branches>{

    public BranchesRepository(JpaRepository<Branches, Long> baseRepository) {
        super(baseRepository);
    }
}
