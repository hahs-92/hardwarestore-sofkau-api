package com.sofkau.hardwarestore.model;

import com.sofkau.hardwarestore.pojo.SupplierPojo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "suppliers")
public class Flyer {

    @Id
    private String id;
    private LocalDate date;
    private SupplierPojo supplier;
    private List<Product> products;

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

    public SupplierPojo getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierPojo supplier) {
        this.supplier = supplier;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
