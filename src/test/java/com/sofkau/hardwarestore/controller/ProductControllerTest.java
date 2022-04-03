package com.sofkau.hardwarestore.controller;


import com.sofkau.hardwarestore.dto.SupplierDto;
import com.sofkau.hardwarestore.model.Product;
import com.sofkau.hardwarestore.service.ProductService;
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

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class ProductControllerTest {

    @MockBean
    private ProductService service;

    @Autowired
    private WebTestClient testClient;

    @Test
    @DisplayName("POST /products")
    void create() throws  Exception {
        SupplierDto supplier1 = new SupplierDto();
        supplier1.setId("23546");
        supplier1.setCitizenshipCard("1234623");
        supplier1.setFullName("Luiz Rodrigues");
        supplier1.setPhoneNumber("321456879");
        supplier1.setEmail("luis@email.com");

        Product product = new Product();
        product.setName("Destornillador");
        product.setPrice(5.000);
        product.setQuantity(2);
        product.setLimit(12);
        product.setSupplier(supplier1);

        Mockito.when(service.create(product)).thenReturn(Mono.just(product));

        testClient.post().uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(product))
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    @DisplayName("POST /products/createAll")
    void createMany() throws  Exception {
        SupplierDto supplier1 = new SupplierDto();
        supplier1.setId("23546");
        supplier1.setCitizenshipCard("1234623");
        supplier1.setFullName("Luiz Rodrigues");
        supplier1.setPhoneNumber("321456879");
        supplier1.setEmail("luis@email.com");

        Product product = new Product();
        product.setName("Tuerca");
        product.setPrice(1.000);
        product.setQuantity(6);
        product.setLimit(12);
        product.setSupplier(supplier1);

        SupplierDto supplier2 = new SupplierDto();
        supplier2.setId("23546");
        supplier2.setCitizenshipCard("1234623");
        supplier2.setFullName("Maria Rodrigues");
        supplier2.setPhoneNumber("311456879");
        supplier2.setEmail("maria@email.com");

        Product product1 = new Product();
        product1.setName("Destornillador");
        product1.setPrice(5.000);
        product1.setQuantity(2);
        product1.setLimit(12);
        product1.setSupplier(supplier2);

        List<Product> productList = Arrays.asList(product1, product);
        Flux<Product> productFlux = Flux.fromIterable(productList);

        Mockito.when(service.createMany(productList)).thenReturn(productFlux);

        testClient.post().uri("/products/createAll")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(productList))
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    @DisplayName("GET /products")
    void getAll() throws  Exception {
        SupplierDto supplier = new SupplierDto();
        supplier.setId("23546");
        supplier.setCitizenshipCard("1234623");
        supplier.setFullName("Luiz Rodrigues");
        supplier.setPhoneNumber("321456879");
        supplier.setEmail("luis@email.com");

        Product product = new Product();
        product.setId("sss");
        product.setName("Destornillador");
        product.setPrice(5.000);
        product.setQuantity(2);
        product.setLimit(12);
        product.setSupplier(supplier);

        List<Product> productList = Arrays.asList(product);
        Flux<Product> productFlux = Flux.fromIterable(productList);

        Mockito.when(service.getAll()).thenReturn(productFlux);

        testClient.get().uri("/products")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Product.class);
    }

    @Test
    @DisplayName("GET /products/{id}")
    void getById() throws  Exception {
        SupplierDto supplier1 = new SupplierDto();
        supplier1.setId("23546");
        supplier1.setCitizenshipCard("1234623");
        supplier1.setFullName("Luiz Rodrigues");
        supplier1.setPhoneNumber("321456879");
        supplier1.setEmail("luis@email.com");

        Product product = new Product();
        product.setId("xxx");
        product.setName("Destornillador");
        product.setPrice(5.000);
        product.setQuantity(2);
        product.setLimit(12);
        product.setSupplier(supplier1);

        Mockito.when(service.getById("xxx")).thenReturn(Mono.just(product));

        testClient.get().uri("/products/{id}", "xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("xxx");

        Mockito.verify(service, Mockito.times(1)).getById("xxx");
    }

    @Test
    @DisplayName("PUT /products")
    void update() throws  Exception {
        SupplierDto supplier1 = new SupplierDto();
        supplier1.setId("23546");
        supplier1.setCitizenshipCard("1234623");
        supplier1.setFullName("Luiz Rodrigues");
        supplier1.setPhoneNumber("321456879");
        supplier1.setEmail("luis@email.com");

        Product product = new Product();
        product.setName("Tuerca");
        product.setPrice(1.000);
        product.setQuantity(6);
        product.setLimit(12);
        product.setSupplier(supplier1);

        SupplierDto supplier2 = new SupplierDto();
        supplier2.setId("23546");
        supplier2.setCitizenshipCard("1234623");
        supplier2.setFullName("Maria Rodrigues");
        supplier2.setPhoneNumber("311456879");
        supplier2.setEmail("maria@email.com");

        Product product1 = new Product();
        product1.setName("Destornillador");
        product1.setPrice(5.000);
        product1.setQuantity(2);
        product1.setLimit(12);
        product1.setSupplier(supplier2);


        Mockito.when(service.update(product)).thenReturn(Mono.just(product1));

        testClient.put().uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(product))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @DisplayName("PUT /products/updateAll")
    void updateMany() throws  Exception {
        SupplierDto supplier1 = new SupplierDto();
        supplier1.setId("23546");
        supplier1.setCitizenshipCard("1234623");
        supplier1.setFullName("Luiz Rodrigues");
        supplier1.setPhoneNumber("321456879");
        supplier1.setEmail("luis@email.com");

        Product product = new Product();
        product.setName("Tuerca");
        product.setPrice(1.000);
        product.setQuantity(6);
        product.setLimit(12);
        product.setSupplier(supplier1);

        SupplierDto supplier2 = new SupplierDto();
        supplier2.setId("23546");
        supplier2.setCitizenshipCard("1234623");
        supplier2.setFullName("Maria Rodrigues");
        supplier2.setPhoneNumber("311456879");
        supplier2.setEmail("maria@email.com");

        Product product1 = new Product();
        product1.setName("Destornillador");
        product1.setPrice(5.000);
        product1.setQuantity(2);
        product1.setLimit(12);
        product1.setSupplier(supplier2);

        List<Product> productList = Arrays.asList(product1, product);
        Flux<Product> productFlux = Flux.fromIterable(productList);

        Mockito.when(service.updateMany(productList)).thenReturn(productFlux);

        testClient.put().uri("/products/updateAll")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(productList))
                .exchange()
                .expectStatus().isOk();
    }


    @Test
    @DisplayName(" DELETE /products/{id}")
    void delete() throws  Exception {
        Mockito.when(service.delete("xxx")).thenReturn(Mono.empty());

        testClient.delete().uri("/products/{id}","xxx")
                .exchange()
                .expectStatus().isOk();
    }
}
