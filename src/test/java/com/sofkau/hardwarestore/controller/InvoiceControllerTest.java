package com.sofkau.hardwarestore.controller;

import com.sofkau.hardwarestore.dto.SupplierDto;
import com.sofkau.hardwarestore.model.Invoice;
import com.sofkau.hardwarestore.dto.ClientDto;
import com.sofkau.hardwarestore.dto.ProductSoldDto;
import com.sofkau.hardwarestore.dto.SellerDto;
import com.sofkau.hardwarestore.service.InvoiceService;
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
public class InvoiceControllerTest {

    @MockBean
    private InvoiceService service;

    @Autowired
    private WebTestClient testClient;

    @Test
    @DisplayName("POST /invoices")
    void create() throws  Exception {
        ClientDto client = new ClientDto();
        client.setCitizenshipCard("112345676");
        client.setFullName("Power Lol");
        client.setPhoneNumber("6666647");

        SellerDto seller = new SellerDto();
        seller.setCitizenshipCard("110113758");
        seller.setFullName("Carmen Lopez");
        seller.setPhoneNumber("322445676");

        SupplierDto supplier = new SupplierDto();
        supplier.setCitizenshipCard("1234623");
        supplier.setFullName("Luiz Rodrigues");
        supplier.setPhoneNumber("321456879");
        supplier.setEmail("luis@email.com");

        ProductSoldDto productSold = new ProductSoldDto();
        productSold.setId("123566576");
        productSold.setName("Destornillador");
        productSold.setPrice(5.000);
        productSold.setQuantity(2);

        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setDate(LocalDate.of(2021,12,12));
        invoice.setSeller(seller);
        invoice.setTotal(10.000);
        invoice.setProducts(Arrays.asList(productSold));

        Mockito.when(service.create(invoice)).thenReturn(Mono.just(invoice));

        testClient.post().uri("/invoices")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(supplier))
                .exchange()
                .expectStatus().isCreated();

    }

    @Test
    @DisplayName("GET /invoices")
    void getAll() throws  Exception {

        ClientDto client = new ClientDto();
        client.setCitizenshipCard("112345676");
        client.setFullName("Power Lol");
        client.setPhoneNumber("6666647");

        SellerDto seller = new SellerDto();
        seller.setCitizenshipCard("110113758");
        seller.setFullName("Carmen Lopez");
        seller.setPhoneNumber("322445676");

        SupplierDto supplier = new SupplierDto();
        supplier.setCitizenshipCard("1234623");
        supplier.setFullName("Luiz Rodrigues");
        supplier.setPhoneNumber("321456879");
        supplier.setEmail("luis@email.com");

        ProductSoldDto productSold = new ProductSoldDto();
        productSold.setId("123566576");
        productSold.setName("Destornillador");
        productSold.setPrice(5.000);
        productSold.setQuantity(2);

        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setDate(LocalDate.of(2021,12,12));
        invoice.setSeller(seller);
        invoice.setTotal(10.000);
        invoice.setProducts(Arrays.asList(productSold));

        List<Invoice> invoiceList = Arrays.asList(invoice);
        Flux<Invoice> invoiceFlux = Flux.fromIterable(invoiceList);

        Mockito.when(service.getAll()).thenReturn(invoiceFlux);

        testClient.get().uri("/invoices")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Invoice.class);
    }

    @Test
    @DisplayName("GET /invoices/{id}")
    void getById() throws  Exception {
        ClientDto client = new ClientDto();
        client.setCitizenshipCard("112345676");
        client.setFullName("Power Lol");
        client.setPhoneNumber("6666647");

        SellerDto seller = new SellerDto();
        seller.setCitizenshipCard("110113758");
        seller.setFullName("Carmen Lopez");
        seller.setPhoneNumber("322445676");

        SupplierDto supplier = new SupplierDto();
        supplier.setCitizenshipCard("1234623");
        supplier.setFullName("Luiz Rodrigues");
        supplier.setPhoneNumber("321456879");
        supplier.setEmail("luis@email.com");

        ProductSoldDto productSold = new ProductSoldDto();
        productSold.setId("123566576");
        productSold.setName("Destornillador");
        productSold.setPrice(5.000);
        productSold.setQuantity(2);

        Invoice invoice = new Invoice();
        invoice.setId("xxx");
        invoice.setDate(LocalDate.of(2021,12,12));
        invoice.setClient(client);
        invoice.setSeller(seller);
        invoice.setTotal(10.000);
        invoice.setProducts(Arrays.asList(productSold));

        Mockito.when(service.getById("xxx")).thenReturn(Mono.just(invoice));

        testClient.get().uri("/invoices/{id}", "xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("xxx");

        Mockito.verify(service, Mockito.times(1)).getById("xxx");
    }


    @Test
    @DisplayName(" DELETE /invoices/{id}")
    void delete() throws  Exception {
        Mockito.when(service.delete("xxx")).thenReturn(Mono.empty());

        testClient.delete().uri("/invoices/{id}","xxx")
                .exchange()
                .expectStatus().isOk();
    }
}
