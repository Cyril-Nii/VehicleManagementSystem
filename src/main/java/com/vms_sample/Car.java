package com.vms_sample;

public class Car extends Vehicle{

        private int numberOfSeats;
        private boolean hasAC;

        public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, int numberOfSeats, boolean hasAC) {
            super(vehicleId, model, baseRentalRate, isAvailable);
            this.numberOfSeats = numberOfSeats;
            this.hasAC = hasAC;
        }

        public int getNumberOfSeats() {
            return numberOfSeats;
        }

        public void setNumberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
        }

        public boolean isHasAC() {
            return hasAC;
        }

        public void setHasAC(boolean hasAC) {
            this.hasAC = hasAC;
        }


        @Override
        public double calculateRentalCost(int days) {
            double rentalCost = getBaseRentalRate() * days;

            if (hasAC) {
                rentalCost += 100;
            }

            return rentalCost;
        }


        @Override
        public boolean isAvailableForRental() {
            return isAvailable();
        }

        @Override
        public String toString() {
            return "--Car--\n" +
                    "Number Of Seats = " + numberOfSeats +
                    "\nAC = " + hasAC +
                    "\nCar Number = " + getVehicleId() +
                    "\nModel = " + getModel() +
                    "\nBase Rental Rate = " + getBaseRentalRate() +
                    "\nIs Available = " + isAvailable() + "\n";
        }


}
