package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.Base;
import com.TodoFood.TodoFood.Services.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController <E> {
    protected BaseService<E> baseService;

    public BaseController(BaseService<E> baseService){
        this.baseService = baseService;
    }

    // GetAll
    @GetMapping
    public ResponseEntity<List<E>>getAll(){
        try{
            List<E> entites = baseService.findAll();
            return ResponseEntity.ok(entites);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    // GetBYId
    @GetMapping("/{id}")
    public ResponseEntity<E> getById(@PathVariable Long id){
        try{
            E entity = baseService.findById(id);
            return ResponseEntity.ok(entity);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    // Create
    @PostMapping
    public ResponseEntity<E> create(@RequestBody E entity){
        try{
            E newEntity = baseService.save(entity);
            return ResponseEntity.status(201).body(newEntity);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<E> update(@PathVariable Long id, @RequestBody E newEntity) {
        System.out.println("Body recibido: " + newEntity);
        try {
            if (newEntity instanceof Base baseEntity){ // Si newEntity es una insatncia de base
                baseEntity.setId(id); // Se fuerza el id del path
            }
            E findEntity = baseService.findById(id);
            if (findEntity == null){
                return ResponseEntity.notFound().build();
            }
            E updateEntity = baseService.update(id, newEntity);
            return ResponseEntity.ok(updateEntity);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<E> delete(@PathVariable Long id){
        try{
            if(baseService.delete(id)){
                return ResponseEntity.ok().build();
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
