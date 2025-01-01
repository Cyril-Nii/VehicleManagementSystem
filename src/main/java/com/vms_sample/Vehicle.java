package com.vms_sample;

public abstract class Vehicle {

    private final String vehicleId;
    private final String manufacturer;
    private final String model;
    private final RentalAgency rentalAgency;
    private boolean isAvailable;
    private final int horsepower;
    private final String color;
    private final TransmissionType transmissionType;
    private double baseRentalRate;

    public enum TransmissionType {
        AUTOMATIC,
        MANUAL
    }

    public Vehicle(String vehicleId, String manufacturer, String model, RentalAgency rentalAgency, boolean isAvailable, String color, int horsepower, TransmissionType transmissionType, double baseRentalRate) {
        if (vehicleId == null || vehicleId.isBlank()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or blank");
        }
        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException("Manufacturer cannot be null or blank");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank");
        }
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color cannot be null or blank");
        }
        if (horsepower <= 0) {
            throw new IllegalArgumentException("Horsepower must be greater than 0");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than 0");
        }
        if (transmissionType == null) {
            throw new IllegalArgumentException("Transmission type cannot be null");
        }

        this.vehicleId = vehicleId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.rentalAgency = rentalAgency;
        this.isAvailable = isAvailable;
        this.color = color;
        this.horsepower = horsepower;
        this.transmissionType = transmissionType;
        this.baseRentalRate = baseRentalRate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public RentalAgency getRentalAgency() {
        return rentalAgency;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        if (available != this.isAvailable) {
            this.isAvailable = available;
        }
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be greater than 0");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public abstract boolean checkAvailability();

    public abstract boolean processRental(Customer customer, int days);
}
