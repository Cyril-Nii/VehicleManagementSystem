package com.vms_sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RentalTransactionTest {

    private RentalTransaction rentalTransaction;
    private Customer customer;
    private Vehicle vehicle;

    @BeforeEach
    public void setUp() {
        customer = new Customer(
            "Cyril Nii Teiko Tagoe",        // name
            "C005",       // customerId
            "Nsawam",     // address
            "0553975837",        // phoneNumber
            "LIC3886542"     // licenseId
        );

        vehicle = new Car(
            "CAR001",           // vehicleId
            "Nissan",           // manufacturer
            "Altima",           // model
            new RentalAgency(), // rentalAgency
            true,               // isAvailable
            "Blue",             // color
            250,                // horsepower
            TransmissionType.AUTOMATIC, // transmissionType
            5,                  // numberOfSeats
            true,               // hasAC
            true,               // hasLeatherSeats
            true                // hasGPS
        );

        rentalTransaction = new RentalTransaction(customer, vehicle, 5);
    }

    @Test
    public void testGetCustomer() {
        assertEquals(customer, rentalTransaction.getCustomer());
    }

    @Test
    public void testGetVehicle() {
        assertEquals(vehicle, rentalTransaction.getVehicle());
    }

    @Test
    public void testGetDays() {
        assertEquals(5, rentalTransaction.getDays());
    }

    @Test
    public void testSetCustomer() {
        Customer newCustomer = new Customer(
            "Bill Spencer",        // name
            "C007",       // customerId
            "Tema",     // address
            "0257775521",        // phoneNumber
            "LIC5622344"     // licenseId
        );
        rentalTransaction.setCustomer(newCustomer);
        assertEquals(newCustomer, rentalTransaction.getCustomer());
    }

    @Test
    public void testSetVehicle() {
        Vehicle newVehicle = new Car(
            "CAR002",           // vehicleId
            "Toyota",           // manufacturer
            "Camry",            // model
            new RentalAgency(), // rentalAgency
            true,               // isAvailable
            "Red",              // color
            200,                // horsepower
            TransmissionType.MANUAL, // transmissionType
            4,                  // numberOfSeats
            false,              // hasAC
            false,              // hasLeatherSeats
            false               // hasGPS
        );
        rentalTransaction.setVehicle(newVehicle);
        assertEquals(newVehicle, rentalTransaction.getVehicle());
    }

    @Test
    public void testSetDays() {
        rentalTransaction.setDays(10);
        assertEquals(10, rentalTransaction.getDays());
    }
}