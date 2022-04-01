package com.sofkau.hardwarestore.repository;

import com.sofkau.hardwarestore.model.Flyer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IFlyerRepository extends ReactiveMongoRepository<Flyer, String> {
}
