package com.sofkau.hardwarestore.model;

import com.sofkau.hardwarestore.dto.ClientDto;
import com.sofkau.hardwarestore.dto.ProductSoldDto;
import com.sofkau.hardwarestore.dto.SellerDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "invoices")
public class Invoice {
    @Id
    private String id;
    private LocalDate date;
    private ClientDto client;
    private SellerDto seller;
    private Double total;
    private List<ProductSoldDto> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public SellerDto getSeller() {
        return seller;
    }

    public void setSeller(SellerDto seller) {
        this.seller = seller;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ProductSoldDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSoldDto> products) {
        this.products = products;
    }
}
