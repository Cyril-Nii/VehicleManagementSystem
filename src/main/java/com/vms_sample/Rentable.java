package com.vms_sample;

public interface Rentable {

    boolean isAvailableForRental();

    double calculateRentalCost(int days);

    boolean returnVehicle();

}
