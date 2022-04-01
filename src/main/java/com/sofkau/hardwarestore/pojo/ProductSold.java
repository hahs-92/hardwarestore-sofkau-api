package com.sofkau.hardwarestore.pojo;


public class ProductSold {
    private String id;
    private String name;
    private Double price;
    private Integer quantity;
    private SupplierPojo supplier;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public SupplierPojo getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierPojo supplier) {
        this.supplier = supplier;
    }
}
