package com.vms_sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer(
            "Cyril Nii Teiko Tagoe",        // name
            "C005",       // customerId
            "Nsawam",     // address
            "0553975837",        // phoneNumber
            "LIC3886542"     // licenseId
        );
    }

    @Test
    public void testGetters() {
        assertEquals("Cyril Nii Teiko Tagoe", customer.getName());
        assertEquals("C005", customer.getCustomerId());
        assertEquals("Nsawam", customer.getAddress());
        assertEquals("0553975837", customer.getPhoneNumber());
        assertEquals("LIC3886542", customer.getLicenseId());
    }

    @Test
    public void testSetters() {
        customer.setName("Yaro Williams");
        customer.setCustomerId("C006");
        customer.setAddress("Legon, Accra");
        customer.setPhoneNumber("0596663422");
        customer.setLicenseId("LIC5622345");

        assertEquals("Yaro Williams", customer.getName());
        assertEquals("C006", customer.getCustomerId());
        assertEquals("Legon, Accra", customer.getAddress());
        assertEquals("0596663422", customer.getPhoneNumber());
        assertEquals("LIC5622345", customer.getLicenseId());
    }

    @Test
    public void testEligibility() {
        assertTrue(customer.isEligible());
        customer.setEligible(false);
        assertFalse(customer.isEligible());
    }

    @Test
    public void testRentalHistory() {
        Vehicle vehicle = new Vehicle("Car", "Toyota", "Corolla", 2020);
        customer.addRental(vehicle);
        List<Vehicle> currentRentals = customer.getCurrentRentals();
        assertEquals(1, currentRentals.size());
        assertEquals(vehicle, currentRentals.get(0));

        customer.returnRental(vehicle);
        List<Vehicle> rentalHistory = customer.getRentalHistory();
        assertEquals(1, rentalHistory.size());
        assertEquals(vehicle, rentalHistory.get(0));
        assertTrue(customer.getCurrentRentals().isEmpty());
    }

    @Test
    public void testCheckEligibility() {
        assertTrue(customer.checkEligibility());
        customer.setEligible(false);
        assertFalse(customer.checkEligibility());
    }
}