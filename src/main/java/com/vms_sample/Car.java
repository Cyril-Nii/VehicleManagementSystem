package com.vms_sample;

public class Car extends Vehicle implements Rentable {

    private int numberOfSeats;
    private boolean hasAC;
    private boolean hasLeatherSeats;
    private boolean hasGPS;
    private final static double baseRentalRate = 120.00;

    // Constructor
    public Car(String vehicleId, String manufacturer, String model, double baseRentalRate, boolean isAvailable, String color, int horsepower, TransmissionType transmissionType, int numberOfSeats, boolean hasAC, boolean hasLeatherSeats, boolean hasGPS) {
        super(vehicleId, manufacturer, model, baseRentalRate, isAvailable, color, horsepower, transmissionType);

        // Validate number of seats
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Number of seats must be greater than 0");
        }

        this.numberOfSeats = numberOfSeats;
        this.hasAC = hasAC;
        this.hasLeatherSeats = hasLeatherSeats;
        this.hasGPS = hasGPS;
    }

    // Getters and Setters
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            return false;
        } else {
            this.numberOfSeats = numberOfSeats;
            return true;
        }
    }

    public boolean getHasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public boolean getHasLeatherSeats() {
        return hasLeatherSeats;
    }

    public void setHasLeatherSeats(boolean hasLeatherSeats) {
        this.hasLeatherSeats = hasLeatherSeats;
    }

    public boolean getHasGPS() {
        return hasGPS;
    }

    public void setHasGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }



    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }


    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            return 0.0;
        } else {
            double rentalRate = getBaseRentalRate();

            // Add additional charges based on the car's features
            if (numberOfSeats > 4) {
                rentalRate += 50.00;
            }

            if (hasAC) {
                rentalRate += 40.00;
            }

            if (hasLeatherSeats) {
                rentalRate += 30.00;
            }

            if (hasGPS) {
                rentalRate += 20.00;
            }

            return rentalRate * days;
        }
    }

    @Override
    public boolean rent(Customer customer, int days){
        if (isAvailableForRental()){
            setIsAvailable(false);
            return true;
        }

        return false;

    }

    @Override
    public boolean returnVehicle() {
        setIsAvailable(true);
        return true;
    }





    //Override the to string method


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;

        return getVehicleId().equals(car.getVehicleId());
    }

    @Override
    public int hashCode() {
        return getVehicleId().hashCode();
    }
}