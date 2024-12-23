package com.vms_sample;

public class Car extends Vehicle{

        private int numberOfSeats;

        // Constructor
        public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, int numberOfSeats) {
            super(vehicleId, model, baseRentalRate, isAvailable);
            this.numberOfSeats = numberOfSeats;
        }


        // Getters and Setters
        public int getNumberOfSeats() {
            return numberOfSeats;
        }

        public void setNumberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
        }



        @Override
        public double calculateRentalCost(int days) {

            double rentalCost = getBaseRentalRate() * days;

            System.out.println("The rental cost for " + getModel() + " for " + days + " is $" + rentalCost);
            return rentalCost;
        }


        @Override
        public boolean isAvailableForRental() {
            return getIsAvailable();
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


}
