package com.example.Ejercicios_10_11_12.controller;

import com.example.Ejercicios_10_11_12.entities.Laptop;
import com.example.Ejercicios_10_11_12.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

        Optional<Laptop> laptopOpt = laptopRepository.findById(id); // 3456546456435

        return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null ){
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
