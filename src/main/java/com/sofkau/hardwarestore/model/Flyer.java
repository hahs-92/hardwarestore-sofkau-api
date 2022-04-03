package com.sofkau.hardwarestore.model;

import com.sofkau.hardwarestore.dto.ProductCreatedDto;
import com.sofkau.hardwarestore.dto.SupplierDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "suppliers")
public class Flyer {

    @Id
    private String id;
    private LocalDate date;
    private String nameSupplier;
    private String citizenshipCardSupplier;
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

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getCitizenshipCardSupplier() {
        return citizenshipCardSupplier;
    }

    public void setCitizenshipCardSupplier(String citizenshipCardSupplier) {
        this.citizenshipCardSupplier = citizenshipCardSupplier;
    }

    public List<ProductCreatedDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCreatedDto> products) {
        this.products = products;
    }
}
