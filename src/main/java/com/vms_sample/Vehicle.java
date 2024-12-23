package com.vms_sample;

public abstract class Vehicle {


    // Private encapsulated fields

    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;



    // Constructors with validation

    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        if (vehicleId == null || vehicleId.isBlank()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or blank");
        }

        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank");
        }

        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than 0");
        }

        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than 0");
        }

        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;

    }



    // Getters and setters

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.isBlank()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or blank");
        }

        else {
            this.vehicleId = vehicleId;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank");
        }

        else {
            this.model = model;
        }
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than 0");
        }

        else {
            this.baseRentalRate = baseRentalRate;
        }
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        if (available != true && available != false) {
            throw new IllegalArgumentException("Availability must be true or false");
        }

        else {
            this.isAvailable = available;
        }
    }



    // Abstract methods for rental calculation
    public abstract double calculateRentalCost(int days);


    // Abstract method for checking availability of vehicle
    public abstract boolean isAvailableForRental();



}
