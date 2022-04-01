package com.sofkau.hardwarestore.controller;

import com.sofkau.hardwarestore.model.Product;
import com.sofkau.hardwarestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService service;


    @PostMapping
    public ResponseEntity<Mono<Product>> create(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(service.create(product), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createAll")
    public ResponseEntity<Flux<Product>> createMany(@RequestBody List<Product> products) {
        try {
            return new ResponseEntity<>(service.createMany(products), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Flux<Product>> getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Product>> getById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<Mono<Product>> update(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(service.update(product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateAll")
    public ResponseEntity<Flux<Product>> updateMany(@RequestBody List<Product> products) {
        try {
            return new ResponseEntity<>(service.updateMany(products), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> DeleteById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
