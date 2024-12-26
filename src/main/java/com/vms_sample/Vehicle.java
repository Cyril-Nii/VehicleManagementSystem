package com.vms_sample;

public abstract class Vehicle {


    // Private encapsulated fields
    private String vehicleId;
    private String manufacturer;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private String color;




    // Constructors with validation
    public Vehicle(String vehicleId, String manufacturer, String model, double baseRentalRate, boolean isAvailable, String color) {
        // Validate vehicle ID
        if (vehicleId == null || vehicleId.isBlank()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or blank");
        }

        // Validate Manufacturer name
        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException("Manufacturer cannot be null or blank");
        }

        // Validate model
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank");
        }

        // Validate color
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color cannot be null or blank");
        }

        // Validate base rental rate
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than 0");
        }

        /*// Validate availability
        if (!isAvailable && isAvailable) {
            throw new IllegalArgumentException("Availability must be true or false");
        }
        */

        this.vehicleId = vehicleId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;
        this.color = color;

    }



    // Getters and setters

    public String getVehicleId() {
        return vehicleId;
    }

    public boolean setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.isBlank()) {
            return false;
        }

        else {
            this.vehicleId = vehicleId;
            return true;
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean setManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.isBlank()) {
            return false;
        }

        else {
            this.manufacturer = manufacturer;
            return true;
        }
    }

    public String getModel() {
        return model;
    }

    public boolean setModel(String model) {
        if (model == null || model.isBlank()) {
            return false;
        }

        else {
            this.model = model;
            return true;
        }
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            return false;
        }

        else {
            this.baseRentalRate = baseRentalRate;
            return true;
        }
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getColor() {
        return color;
    }

    public boolean setColor(String color) {
        if (color == null || color.isBlank()) {
            return false;
        }

        else {
            this.color = color;
            return true;
        }
    }



    // Abstract method for rental calculation
    public abstract double calculateRentalCost(int days);


    // Abstract method for checking availability of vehicle for rent
    public abstract boolean isAvailableForRental();


}
