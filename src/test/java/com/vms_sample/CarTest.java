package com.vms_sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CarTest {

    @Test
    public void testCalculateRentalCost() {
        Car car = new Car("GS-6260-Z", "Toyota Corolla", 0.06, true, 4);
        double cost = car.calculateRentalCost(3);
        assertEquals(0.18, cost, "Rental cost should be 0.18");
    }

    @Test
    public void testIsAvailableForRental() {
        Car car = new Car("GS-6260-Z", "Toyota Corolla", 0.06, true, 4);
        assertTrue(car.isAvailableForRental(), "Car should be available for rental");
    }

    @Test
    public void testSetAndGetVehicleId() {
        Car car = new Car("GS-6260-Z", "Toyota Corolla", 0.06, true, 4);
        car.setVehicleId("GS-1234-X");
        assertEquals("GS-1234-X", car.getVehicleId(), "Vehicle ID should be GS-1234-X");
    }

    @Test
    public void testSetAndGetModel() {
        Car car = new Car("GS-6260-Z", "Toyota Corolla", 0.06, true, 4);
        car.setModel("Honda Civic");
        assertEquals("Honda Civic", car.getModel(), "Model should be Honda Civic");
    }

    @Test
    public void testSetAndGetBaseRentalRate() {
        Car car = new Car("GS-6260-Z", "Toyota Corolla", 0.06, true, 4);
        car.setBaseRentalRate(0.08);
        assertEquals(0.08, car.getBaseRentalRate(), "Base rental rate should be 0.08");
    }

    @Test
    public void testSetAndGetIsAvailable() {
        Car car = new Car("GS-6260-Z", "Toyota Corolla", 0.06, true, 4);
        car.setAvailable(false);
        assertFalse(car.getIsAvailable(), "Car should not be available for rental");
    }

    @Test
    public void testSetAndGetNumberOfSeats() {
        Car car = new Car("GS-6260-Z", "Toyota Corolla", 0.06, true, 4);
        car.setNumberOfSeats(5);
        assertEquals(5, car.getNumberOfSeats(), "Number of seats should be 5");
    }


}
