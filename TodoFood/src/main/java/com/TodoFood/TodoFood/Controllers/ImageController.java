package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Image;
import com.TodoFood.TodoFood.Services.BaseService;
import com.TodoFood.TodoFood.Services.ImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoFood/image")
public class ImageController extends BaseController<Image>{

    public ImageController(ImageService imageService) {
        super(imageService);
    }
}
