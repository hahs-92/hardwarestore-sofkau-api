package com.sofkau.hardwarestore.repository;

import com.sofkau.hardwarestore.model.Supplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ISupplierRepository  extends ReactiveMongoRepository<Supplier, String> {
}
