package com.vms_sample;

public class Truck extends Vehicle implements Rentable{

    private double cargoCapacity;
    private boolean hasTrailer;
    private final double baseRentalRate = 100.00;

    // Constructor
    public Truck(String vehicleId, String manufacturer, String model, RentalAgency rentalAgency, boolean isAvailable, String color, int horsepower, TransmissionType transmissionType, double cargoCapacity, boolean hasTrailer) {
        super(vehicleId, manufacturer, model, isAvailable, color, horsepower, transmissionType);

        // Validate cargo capacity
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be greater than 0");
        }

        this.rentalAgency = rentalAgency;
        this.cargoCapacity = cargoCapacity;
        this.hasTrailer = hasTrailer;
    }

    // Getters and Setters
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public boolean setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity <= 0) {
            return false;
        } else {
            this.cargoCapacity = cargoCapacity;
            return true;
        }
    }

    public boolean getHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }



    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            return 0.0;
        } else {
            double rentalRate = baseRentalRate;

            if (cargoCapacity > 1000) {
                rentalRate += 100.00;
            }

            if (hasTrailer) {
                rentalRate += 30.00;
            }

            return rentalRate * days;
        }
    }

    @Override
    public boolean rent(Customer customer, int days) {
        
        if (isAvailableForRental() && customer.isEligible()) {
            setIsAvailable(false);
            customer.addRental(this);          
            setTrucksRented(getTrucksRented() + 1);
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
    public boolean isAvailableForRental() {
        return isAvailable();
    }





    

    @Override
    public String toString() {
        return "--Truck--\n" +
                "Model = " + getModel() +
                "\nTruck Number = " + getVehicleId() +
                "\nCargo Capacity = " + cargoCapacity +
                "\nHas Trailer = " + hasTrailer +
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

        Truck truck = (Truck) obj;

        return getVehicleId().equals(truck.getVehicleId());
    }

    @Override
    public int hashCode() {
        return getVehicleId().hashCode();
    }
}
