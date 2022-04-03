package com.sofkau.hardwarestore.controller;

import com.sofkau.hardwarestore.model.Flyer;
import com.sofkau.hardwarestore.service.FlyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flyers")
@CrossOrigin(origins = "*")
public class FlyerController {

    @Autowired
    private FlyerService service;

    @PostMapping
    public ResponseEntity<Mono<Flyer>> create(@RequestBody Flyer flyer) {
        try {
            return new ResponseEntity<>(service.create(flyer), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Flux<Flyer>> getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Flyer>> getById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
