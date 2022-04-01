package com.sofkau.hardwarestore.repository;

import com.sofkau.hardwarestore.model.Invoice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IInvoiceRepository extends ReactiveMongoRepository<Invoice, String> {
}
