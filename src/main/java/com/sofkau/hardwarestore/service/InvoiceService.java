package com.sofkau.hardwarestore.service;

import com.sofkau.hardwarestore.model.Invoice;
import com.sofkau.hardwarestore.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvoiceService {
    @Autowired
    private IInvoiceRepository repository;

    private Mono<Invoice> create(Invoice invoice) {
        return repository.save(invoice);
    }

    private Flux<Invoice> getAll() {
        return repository.findAll();
    }

    private Mono<Invoice> getById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.empty());
    }

    private Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

}
