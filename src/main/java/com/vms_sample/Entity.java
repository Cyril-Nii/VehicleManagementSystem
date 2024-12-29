package com.vms_sample;

import java.util.zip.Adler32;

public abstract class Entity {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String licenseId;


    public Entity(String name, String phoneNumber, String email, String id, String address, String licenseId) {

        if (id == null || id.length() != 5) {
            throw new IllegalArgumentException("ID must be exactly 5 characters long");
        }

        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }

        if (email == null || email.isBlank()){
            throw new IllegalArgumentException("Email cannot be null or blank");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (address == null || address.isBlank()){
            throw new IllegalArgumentException("Address cannot be null or blank");
        }

        if (licenseId == null || licenseId.length() != 9) {
            throw new IllegalArgumentException("License ID must be exactly 9 characters long");
        }

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.licenseId = licenseId;
    }



    public String getId(){
        return id;
    }

    public boolean setID (String id){
        if (id == null || id.length() != 5){
            return false;
        } else {
            this.id = id;
            return true;
        }
    }

    public String getName(){
        return name;
    }

    public boolean setName(String name){
        if (name == null || name.isBlank()){
            return false;
        } else {
            this.name = name;
            return true;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber){
        if (phoneNumber == null || phoneNumber.isBlank()){
            return false;
        } else {
            this.phoneNumber = phoneNumber;
            return true;
        }
    }

    public String getEmail(){
        return email;
    }

    public boolean setEmail(String email){
        if (email == null || email.isBlank()){
            return false;
        } else {
            this.email = email;
            return true;
        }
    }

    public String getAddress(){
        return address;
    }

    public boolean setAddress(String address){
        if (address == null || address.isBlank()){
            return false;
        } else {
            this.address = address;
            return true;
        }
    }

    public String getLicenseId(){
        return licenseId;
    }

    public boolean setLicenseId(String licenseId){
        if (licenseId == null || licenseId.length() != 9){
            return false;
        } else {
            this.licenseId = licenseId;
            return true;
        }
    }





}
