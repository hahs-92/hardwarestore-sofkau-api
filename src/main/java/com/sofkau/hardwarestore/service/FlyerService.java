package com.sofkau.hardwarestore.service;

import com.sofkau.hardwarestore.model.Flyer;
import com.sofkau.hardwarestore.repository.IFlyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FlyerService {

    @Autowired
    private IFlyerRepository repository;

    public Mono<Flyer> create(Flyer flyer) {
        return repository.save(flyer);
    }

    public Flux<Flyer> getAll() {
        return repository.findAll();
    }

    public Mono<Flyer> getById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
