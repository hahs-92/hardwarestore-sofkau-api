package com.sofkau.hardwarestore.service;

import com.sofkau.hardwarestore.model.Invoice;
import com.sofkau.hardwarestore.model.Product;
import com.sofkau.hardwarestore.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository repository;

    public Mono<Product> create(Product product) {
        return repository.save(product);
    }

    public Flux<Product> createMany(List<Product> products) {
        return repository.saveAll(products);
    }

    public Flux<Product> getAll() {
        return repository.findAll();
    }

    public Mono<Product> getById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Product> update(Product product) {
        return repository.save(product);
    }

    public Flux<Product> updateMany(List<Product> products) {
        return repository.saveAll(products);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
