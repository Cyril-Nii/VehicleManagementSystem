package com.vms_sample;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {

    private String AgencyName;
    private String AgencyAddress;
    private String AgencyPhoneNumber;

    private List<Vehicle> fleet;
    private List<RentalTransaction> transactions;

    private int carsRented;
    private int trucksRented;
    private int motorcyclesRented;
    private int totalRented;

    

    public RentalAgency(String AgencyName, String AgencyAddress, String AgencyPhoneNumber) {
        this.AgencyName = AgencyName;
        this.AgencyAddress = AgencyAddress;
        this.AgencyPhoneNumber = AgencyPhoneNumber;
        this.fleet = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }




    public int getCarsRented() {
        return carsRented;
    }

    public void setCarsRented(int carsRented) {
        this.carsRented = carsRented;
    }

    public int getTrucksRented() {
        return trucksRented;
    }

    public void setTrucksRented(int trucksRented) {
        this.trucksRented = trucksRented;
    }

    public int getMotorcyclesRented() {
        return motorcyclesRented;
    }

    public void setMotorcyclesRented(int motorcyclesRented) {
        this.motorcyclesRented = motorcyclesRented;
    }

    public int getTotalRented() {
        return trucksRented + carsRented + motorcyclesRented;
    }

    public String getAgencyName() {
        return AgencyName;
    }  

    public void setAgencyName(String AgencyName) {
        this.AgencyName = AgencyName;
    }

    public String getAgencyAddress() {
        return AgencyAddress;
    }

    public void setAgencyAddress(String AgencyAddress) {
        this.AgencyAddress = AgencyAddress;
    }

    public String getAgencyPhoneNumber() {
        return AgencyPhoneNumber;
    }

    public void setAgencyPhoneNumber(String AgencyPhoneNumber) {
        this.AgencyPhoneNumber = AgencyPhoneNumber;
    }


    public void addVehicleToFleet(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void removeVehicleFromFleet(Vehicle vehicle) {
        fleet.remove(vehicle);
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public void processRental(Customer customer, Vehicle vehicle, int days) {
        if (vehicle.isAvailableForRental() && customer.isEligible()) {
            customer.addRental(vehicle);
            transactions.add(new RentalTransaction(customer, vehicle, days));
        }
    }


    public String generateReport() {
        return "Rental Agency Report" +
                "\nTotal Fleet Size: " + fleet.size() +
                "\nTotal Transactions: " + transactions.size() +
                "\nCars Rented: " + carsRented +
                "\nTrucks Rented: " + trucksRented +
                "\nMotorcycles Rented: " + motorcyclesRented;
    }


    public List<RentalTransaction> getTransactions() {
        return transactions;
    }
}