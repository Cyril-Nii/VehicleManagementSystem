package com.vms_sample;

public class Motorcycle extends Vehicle implements Rentable {

    private boolean hasSidecar;
    private boolean isOffroad;
    private final double baseRentalRate = 80.00;

    // Constructor
    public Motorcycle(String vehicleId, String manufacturer, String model, boolean isAvailable, String color, int horsepower, TransmissionType transmissionType, boolean hasSidecar, boolean isOffroad) {
        super(vehicleId, manufacturer, model, isAvailable, color, horsepower, transmissionType);

        this.hasSidecar = hasSidecar;
        this.isOffroad = isOffroad;
    }

    // Getters and Setters
    public boolean getHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    public boolean getIsOffroad() {
        return isOffroad;
    }

    public void setIsOffroad(boolean isOffroad) {
        this.isOffroad = isOffroad;
    }



    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            return 0.0;
        } else {
            double rentalRate = baseRentalRate;

            // Add additional charges based on the motorcycle's features
            if (hasSidecar) {
                rentalRate += 20.00;
            }

            if (isOffroad) {
                rentalRate += 30.00;
            }

            return rentalRate * days;
        }
    }


    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }


    @Override
    public boolean rent(Customer customer, int days) {
        if (isAvailableForRental() && customer.isEligible()) {
            setIsAvailable(false);
            customer.addRental(this);   
            setMotorcyclesRented(getMotorcyclesRented() + 1);
            return true;
        }
        return false;
    }


    @Override
    public boolean returnVehicle() {
        setIsAvailable(true);
        return true;
    }



    @Override
    public String toString() {
        return "--Motorcycle--\n" +
                "Model = " + getModel() +
                "\nMotorcycle Number = " + getVehicleId() +
                "\nHas Sidecar = " + hasSidecar +
                "\nIs Offroad = " + isOffroad +
                "\nBase Rental Rate = " + getBaseRentalRate() +
                "\nIs Available = " + isAvailable() + "\n";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Motorcycle motorcycle = (Motorcycle) obj;

        return getVehicleId().equals(motorcycle.getVehicleId());
    }


    @Override
    public int hashCode() {
        return getVehicleId().hashCode();
    }



}