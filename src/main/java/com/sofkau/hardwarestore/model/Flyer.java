package com.sofkau.hardwarestore.model;

import com.sofkau.hardwarestore.dto.ProductCreatedDto;
import com.sofkau.hardwarestore.dto.SupplierDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "flyers")
public class Flyer {

    @Id
    private String id;
    private LocalDate date;
    private SupplierDto supplier;
    private List<ProductCreatedDto> products;

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

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public List<ProductCreatedDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCreatedDto> products) {
        this.products = products;
    }
}
