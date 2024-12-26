package com.vms_sample;

public class Car extends Vehicle{

        private int numberOfSeats;
        private boolean hasAC;
        private boolean hasLeatherSeats;
        private boolean hasGPS;
        private double baseRentalRate = 120.00;


        // Constructor
        public Car(String vehicleId, String manufacturer, String model, double baseRentalRate, boolean isAvailable, String color, int numberOfSeats, boolean hasAC, boolean hasLeatherSeats, boolean hasGPS) {
            super(vehicleId, manufacturer, model, baseRentalRate, isAvailable, color);
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
            }

            else {
                this.numberOfSeats = numberOfSeats;
                return true;
            }
        }

        public boolean getHasAC() {
            return hasAC;
        }

        public boolean setHasAC(boolean hasAC) {
            this.hasAC = hasAC;
            return true;
        }

        public boolean getHasLeatherSeats() {
            return hasLeatherSeats;
        }

        public boolean setHasLeatherSeats(boolean hasLeatherSeats) {
            this.hasLeatherSeats = hasLeatherSeats;
            return true;
        }

        public boolean getHasGPS() {
            return hasGPS;
        }

        public boolean setHasGPS(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return true;
        }



        @Override
        public double calculateRentalCost(int days) {
            if (days <= 0) {
                return 0.0;
            }

            else {
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

                double rentalCost = rentalRate * days;

                return rentalCost;
            }
        }

        @Override
        public boolean isAvailableForRental() {
            //if(){

            //}

            //else {
                return getIsAvailable();
            //}
        }

        @Override
        public String toString() {
            return "--Car--\n" +
                    "Model = " + getModel() +
                    "\nCar Number = " + getVehicleId() +
                    "\nNumber Of Seats = " + numberOfSeats +
                    "\nBase Rental Rate = " + getBaseRentalRate() +
                    "\nIs Available = " + getIsAvailable() + "\n";
        }

        // Override equals() and hashCode() methods
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
