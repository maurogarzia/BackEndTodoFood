package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService extends BaseService<Image>{

    public ImageService(JpaRepository<Image, Long> baseRepository) {
        super(baseRepository);
    }
}
