package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Branches;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.BranchesServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/branches")
public class BranchesController extends BaseController<Branches>{
    public BranchesController(BranchesServices branchesServices) {
        super(branchesServices);
    }


}
