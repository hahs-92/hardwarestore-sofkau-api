package com.sofkau.hardwarestore.service;

import com.sofkau.hardwarestore.model.Supplier;
import com.sofkau.hardwarestore.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SupplierService {
    @Autowired
    public ISupplierRepository repository;

    public Mono<Supplier> create(Supplier  supplier) {
        return repository.save(supplier);
    }

    public Flux<Supplier> getAll() {
        return repository.findAll();
    }

    public Mono<Supplier> getById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Supplier> update(Supplier supplier) {
        return repository.save(supplier);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
