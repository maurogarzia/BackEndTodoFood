package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Image;
import com.TodoFood.TodoFood.Services.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("todoFood/upload")
public class CloudinaryController {
    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file){
        try {
            Image savedImage =cloudinaryService.uploadFile(file);
            return ResponseEntity.ok(savedImage); // Devuelve el objeto guardado(con id y url)
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error al subir la imagen: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            Image updatedImage = cloudinaryService.updateImage(id, file);
            return ResponseEntity.ok(updatedImage);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar la imagen: " + e.getMessage());
        }
    }
}
