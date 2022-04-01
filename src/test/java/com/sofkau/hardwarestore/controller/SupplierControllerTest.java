package com.sofkau.hardwarestore.controller;

import com.sofkau.hardwarestore.model.Supplier;
import com.sofkau.hardwarestore.service.SupplierService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class SupplierControllerTest {

    @MockBean
    private SupplierService service;

    @Autowired
    private WebTestClient testClient;

    @Test
    @DisplayName("POST /suppliers")
    void create() throws  Exception {
        Supplier supplier = new Supplier();
        supplier.setId("xxx");
        supplier.setCitizenshipCard("112232455");
        supplier.setFullName("Jose Manuel Gomez");
        supplier.setPhoneNumber("321456765");
        supplier.setEmail("jose@email.com");

        Mockito.when(service.create(supplier)).thenReturn(Mono.just(supplier));

        testClient.post().uri("/suppliers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(supplier))
                .exchange()
                .expectStatus().isCreated();

    }

    @Test
    @DisplayName("GET /suppliers")
    void getAll() throws  Exception {
        Supplier supplier = new Supplier();
        supplier.setId("xxx");
        supplier.setCitizenshipCard("112232455");
        supplier.setFullName("Jose Manuel Gomez");
        supplier.setPhoneNumber("321456765");
        supplier.setEmail("jose@email.com");

        Supplier supplier2 = new Supplier();
        supplier2.setId("yyy");
        supplier2.setCitizenshipCard("102232455");
        supplier2.setFullName("Maria Herrea");
        supplier2.setPhoneNumber("311436465");
        supplier2.setEmail("maria@email.com");

        List<Supplier> supplierList = List.of(supplier, supplier2);
        Flux<Supplier> supplierFlux = Flux.fromIterable(supplierList);

        Mockito.when(service.getAll()).thenReturn(supplierFlux);

        testClient.get().uri("/suppliers")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Supplier.class);
    }

    @Test
    @DisplayName("GET /suppliers/{id}")
    void getById() throws  Exception {
        Supplier supplier = new Supplier();
        supplier.setId("xxx");
        supplier.setCitizenshipCard("112232455");
        supplier.setFullName("Jose Manuel Gomez");
        supplier.setPhoneNumber("321456765");
        supplier.setEmail("jose@email.com");

        Mockito.when(service.getById("xxx")).thenReturn(Mono.just(supplier));

        testClient.get().uri("/suppliers/{id}", "xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("xxx");

        Mockito.verify(service, Mockito.times(1)).getById("xxx");
    }

    @Test
    @DisplayName("PUT /suppliers")
    void update() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setId("xxx");
        supplier.setCitizenshipCard("112232455");
        supplier.setFullName("Jose Manuel Gomez");
        supplier.setPhoneNumber("321456765");
        supplier.setEmail("jose@email.com");

        Supplier supplierUpdated = new Supplier();
        supplierUpdated.setId("xxx");
        supplierUpdated.setCitizenshipCard("112232455");
        supplierUpdated.setFullName("Jose Gomez");
        supplierUpdated.setPhoneNumber("322456765");
        supplierUpdated.setEmail("jose@email.com");

        Mockito.when(service.update(supplier)).thenReturn(Mono.just(supplierUpdated));

        testClient.put().uri("/suppliers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(supplier))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @DisplayName(" DELETE /resources/{id}")
    void delete() throws  Exception {
        Mockito.when(service.delete("xxx")).thenReturn(Mono.empty());

        testClient.delete().uri("/suppliers/{id}","xxx")
                .exchange()
                .expectStatus().isOk();
    }
}

