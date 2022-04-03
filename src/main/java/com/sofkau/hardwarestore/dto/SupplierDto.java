package com.sofkau.hardwarestore.dto;

public class SupplierDto {
    private String id;
    private String citizenshipCard;
    private String fullName;
    private String  phoneNumber;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCitizenshipCard() {
        return citizenshipCard;
    }

    public void setCitizenshipCard(String citizenshipCard) {
        this.citizenshipCard = citizenshipCard;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
