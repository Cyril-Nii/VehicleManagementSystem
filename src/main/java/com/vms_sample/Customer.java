package com.vms_sample;

public class Customer {

    private String name;
    private String customerId;
    private String address;
    private String phoneNumber;
    private String licenseId;
    private boolean isEligible;


    public Customer(String name, String customerId, String address, String phoneNumber, String licenseId) {
        this.name = name;
        this.customerId = customerId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.licenseId = licenseId;
    }


    // Getters and setters
    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public String getCustomerId() {
        return customerId;
    }

    public boolean setCustomerId(String customerId) {
        this.customerId = customerId;
        return true;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        this.address = address;
        return true;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return true;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public boolean setLicenseId(String licenseId) {
        this.licenseId = licenseId;
        return true;
    }


    // Manage customer rental history
    //Track current rentals
    //Implement rental eligibility checks

}
