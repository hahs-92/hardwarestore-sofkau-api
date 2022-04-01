package com.sofkau.hardwarestore.service;

import com.sofkau.hardwarestore.model.Invoice;
import com.sofkau.hardwarestore.model.Product;
import com.sofkau.hardwarestore.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private IProductRepository repository;

    private Mono<Product> create(Product product) {
        return repository.save(product);
    }

    private Flux<Product> getAll() {
        return repository.findAll();
    }

    private Mono<Product> getById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.empty());
    }

    private Mono<Product> update(Product product) {
        return repository.save(product);
    }

    private Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
