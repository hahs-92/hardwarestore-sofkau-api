package com.sofkau.hardwarestore.repository;

import com.sofkau.hardwarestore.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
}
