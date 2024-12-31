package com.vms_sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RentalAgencyTest {

    private RentalAgency rentalAgency;
    private Customer customer;
    private Vehicle car;
    private Vehicle truck;

    @BeforeEach
    public void setUp() {
        rentalAgency = new RentalAgency();
        customer = new Customer(
            "Cyril Nii Teiko Tagoe",        // name
            "C005",       // customerId
            "Nsawam",     // address
            "0553975837",        // phoneNumber
            "LIC3886542"     // licenseId
        );

        car = new Car(
            "CAR001",           // vehicleId
            "Nissan",           // manufacturer
            "Altima",           // model
            rentalAgency,       // rentalAgency
            true,               // isAvailable
            "Blue",             // color
            250,                // horsepower
            TransmissionType.AUTOMATIC, // transmissionType
            5,                  // numberOfSeats
            true,               // hasAC
            true,               // hasLeatherSeats
            true                // hasGPS
        );

        truck = new Truck(
            "T0001",           // vehicleId
            "Chevrolet",       // manufacturer
            "S-10",            // model
            rentalAgency,      // rentalAgency
            true,              // isAvailable
            "Yellow",          // color
            450,               // horsepower
            TransmissionType.AUTOMATIC, // transmissionType
            5000.0,            // cargoCapacity
            false              // hasTrailer
        );
    }

    @Test
    public void testAddVehicleToFleet() {
        rentalAgency.addVehicleToFleet(car);
        rentalAgency.addVehicleToFleet(truck);
        assertEquals(2, rentalAgency.getFleet().size());
        assertTrue(rentalAgency.getFleet().contains(car));
        assertTrue(rentalAgency.getFleet().contains(truck));
    }

    @Test
    public void testRemoveVehicleFromFleet() {
        rentalAgency.addVehicleToFleet(car);
        rentalAgency.addVehicleToFleet(truck);
        rentalAgency.removeVehicleFromFleet(car);
        assertEquals(1, rentalAgency.getFleet().size());
        assertFalse(rentalAgency.getFleet().contains(car));
        assertTrue(rentalAgency.getFleet().contains(truck));
    }

    @Test
    public void testProcessRental() {
        rentalAgency.addVehicleToFleet(car);
        rentalAgency.processRental(customer, car, 5);
        assertFalse(car.isAvailable());
        assertEquals(1, rentalAgency.getTransactions().size());
    }

    @Test
    public void testReturnRental() {
        rentalAgency.addVehicleToFleet(car);
        rentalAgency.processRental(customer, car, 5);
        rentalAgency.returnRental(customer, car);
        assertTrue(car.isAvailable());
        assertEquals(1, rentalAgency.getTransactions().size());
    }

    @Test
    public void testGenerateReport() {
        rentalAgency.addVehicleToFleet(car);
        rentalAgency.addVehicleToFleet(truck);
        rentalAgency.processRental(customer, car, 5);
        rentalAgency.processRental(customer, truck, 3);
        String report = rentalAgency.generateReport();
        assertNotNull(report);
        assertTrue(report.contains("Nissan Altima"));
        assertTrue(report.contains("Chevrolet S-10"));
        assertTrue(report.contains("Cyril Nii Teiko Tagoe"));
    }

    @Test
    public void testSetAndGetTrucksRented() {
        rentalAgency.setTrucksRented(5);
        assertEquals(5, rentalAgency.getTrucksRented());
    }

    @Test
    public void testSetAndGetMotorcyclesRented() {
        rentalAgency.setMotorcyclesRented(3);
        assertEquals(3, rentalAgency.getMotorcyclesRented());
    }

    @Test
    public void testGetTotalRented() {
        rentalAgency.setTrucksRented(5);
        rentalAgency.setCarsRented(10);
        rentalAgency.setMotorcyclesRented(3);
        assertEquals(18, rentalAgency.getTotalRented());
    }

    @Test
    public void testSetAndGetAgencyName() {
        rentalAgency.setAgencyName("Adom Rentals");
        assertEquals("Adom Rentals", rentalAgency.getAgencyName());
    }
}