package com.sofkau.hardwarestore.pojo;


public class Seller {
    private String citizenshipCard;
    private String fullName;
    private String PhoneNumber;
    private Integer age;

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
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
