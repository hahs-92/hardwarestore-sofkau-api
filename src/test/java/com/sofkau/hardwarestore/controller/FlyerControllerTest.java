package com.sofkau.hardwarestore.controller;

import com.sofkau.hardwarestore.dto.ProductCreatedDto;
import com.sofkau.hardwarestore.model.Flyer;
import com.sofkau.hardwarestore.model.Invoice;
import com.sofkau.hardwarestore.dto.SupplierDto;
import com.sofkau.hardwarestore.service.FlyerService;
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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class FlyerControllerTest {

    @MockBean
    private FlyerService service;

    @Autowired
    private WebTestClient testClient;


    @Test
    @DisplayName("POST /flyers")
    void create() throws  Exception {
        SupplierDto supplier1 = new SupplierDto();
        supplier1.setCitizenshipCard("1234623");
        supplier1.setFullName("Luiz Rodrigues");
        supplier1.setPhoneNumber("321456879");
        supplier1.setEmail("luis@email.com");

        ProductCreatedDto product = new ProductCreatedDto();
        product.setId("sss");
        product.setName("Destornillador");
        product.setPrice(5.000);
        product.setQuantity(2);
        product.setLimit(12);

        Flyer flyer = new Flyer();
        flyer.setDate(LocalDate.of(2022, 12,9));
        flyer.setSupplier(supplier1);
        flyer.setProducts(Arrays.asList(product));

        Mockito.when(service.create(flyer)).thenReturn(Mono.just(flyer));

        testClient.post().uri("/flyers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(flyer))
                .exchange()
                .expectStatus().isCreated();

    }

    @Test
    @DisplayName("GET /flyers")
    void getAll() throws  Exception {
        SupplierDto supplier = new SupplierDto();
        supplier.setCitizenshipCard("1234623");
        supplier.setFullName("Luiz Rodrigues");
        supplier.setPhoneNumber("321456879");
        supplier.setEmail("luis@email.com");

        ProductCreatedDto product = new ProductCreatedDto();
        product.setId("sss");
        product.setName("Destornillador");
        product.setPrice(5.000);
        product.setQuantity(2);
        product.setLimit(12);

        Flyer flyer = new Flyer();
        flyer.setDate(LocalDate.of(2022, 12,9));
        flyer.setSupplier(supplier);
        flyer.setProducts(Arrays.asList(product));

        List<Flyer> flyerList = Arrays.asList(flyer);
        Flux<Flyer> flyerFlux = Flux.fromIterable(flyerList);

        Mockito.when(service.getAll()).thenReturn(flyerFlux);

        testClient.get().uri("/flyers")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Invoice.class);
    }

    @Test
    @DisplayName("GET /flyers/{id}")
    void getById() throws  Exception {
        SupplierDto supplier1 = new SupplierDto();
        supplier1.setCitizenshipCard("1234623");
        supplier1.setFullName("Luiz Rodrigues");
        supplier1.setPhoneNumber("321456879");
        supplier1.setEmail("luis@email.com");

        ProductCreatedDto product = new ProductCreatedDto();
        product.setId("sss");
        product.setName("Destornillador");
        product.setPrice(5.000);
        product.setQuantity(2);
        product.setLimit(12);

        Flyer flyer = new Flyer();
        flyer.setId("xxx");
        flyer.setDate(LocalDate.of(2022, 12,9));
        flyer.setSupplier(supplier1);
        flyer.setProducts(Arrays.asList(product));

        Mockito.when(service.getById("xxx")).thenReturn(Mono.just(flyer));

        testClient.get().uri("/flyers/{id}", "xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("xxx");

        Mockito.verify(service, Mockito.times(1)).getById("xxx");
    }


    @Test
    @DisplayName(" DELETE /flyers/{id}")
    void delete() throws  Exception {
        Mockito.when(service.delete("xxx")).thenReturn(Mono.empty());

        testClient.delete().uri("/flyers/{id}","xxx")
                .exchange()
                .expectStatus().isOk();
    }
}
