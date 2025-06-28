package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Image;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/image")
public class ImageController extends BaseController<Image>{

    public ImageController(BaseService<Image> baseService) {
        super(baseService);
    }
}
