package com.vms_sample;

public abstract class Vehicle {

    // Private encapsulated fields
    private String vehicleId;
    private String manufacturer;
    private String model;
    private boolean isAvailable;
    private int horsepower;
    private String color;
    private TransmissionType transmissionType;

    /**
     * Enum for Transmission Type.
     * I am using transmission type as an enum because it is a fixed set of values.
     */

    public enum TransmissionType {
        AUTOMATIC,
        MANUAL
    }

    // Constructors with validation
    public Vehicle(String vehicleId, String manufacturer, String model, boolean isAvailable, String color, int horsepower, TransmissionType transmissionType) {
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


        // Validate horsepower
        if (horsepower <= 0) {
            throw new IllegalArgumentException("Horsepower must be greater than 0");
        }

        // Validate transmission type
        if (transmissionType == null) {
            throw new IllegalArgumentException("Transmission type cannot be null");
        }

        this.vehicleId = vehicleId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.isAvailable = isAvailable;
        this.color = color;
        this.horsepower = horsepower;
        this.transmissionType = transmissionType;
    }

    // Getters and setters
    public String getVehicleId() {
        return vehicleId;
    }

    public boolean setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.isBlank()) {
            return false;
        } else {
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
        } else {
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
        } else {
            this.model = model;
            return true;
        }
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }


    /**
     * It should have been getIsAvailable but In Java, the convention
     * for boolean getters is to use the is prefix.
     */

    public boolean isAvailable() {
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
        } else {
            this.color = color;
            return true;
        }
    }

    public int getHorsepower() {
        return horsepower;
    }

    public boolean setHorsepower(int horsepower) {
        if (horsepower <= 0) {
            return false;
        } else {
            this.horsepower = horsepower;
            return true;
        }
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public boolean setTransmissionType(TransmissionType transmissionType) {
        if (transmissionType == null) {
            return false;
        } else {
            this.transmissionType = transmissionType;
            return true;
        }
    }



    // Abstract method for rental calculation
    public abstract double calculateRentalCost(int days);


    // Abstract method for checking availability of vehicle for rent
    public abstract boolean isAvailableForRental();
}