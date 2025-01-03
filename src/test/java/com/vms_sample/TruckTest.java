package com.vms_sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    private Truck truck;
    private RentalAgency rentalAgency;

    @BeforeEach
    void setUp() {
        rentalAgency = new RentalAgency("Test Agency", "1234567890", "test@example.com");
        truck = new Truck("T123", "Toyota", "Tundra", rentalAgency, true, "Red", 381, Vehicle.TransmissionType.AUTOMATIC, 2000, true);
    }

    @Test
    void getVehicleId() {
        assertEquals("T123", truck.getVehicleId());
    }

    @Test
    void setVehicleId() {
        truck.setVehicleId("T124");
        assertEquals("T124", truck.getVehicleId());
    }

    @Test
    void getManufacturer() {
        assertEquals("Toyota", truck.getManufacturer());
    }

    @Test
    void setManufacturer() {
        truck.setManufacturer("Ford");
        assertEquals("Ford", truck.getManufacturer());
    }

    @Test
    void getModel() {
        assertEquals("Tundra", truck.getModel());
    }

    @Test
    void setModel() {
        truck.setModel("F-150");
        assertEquals("F-150", truck.getModel());
    }

    @Test
    void getRentalAgency() {
        assertEquals(rentalAgency, truck.getRentalAgency());
    }

    @Test
    void setRentalAgency() {
        RentalAgency newAgency = new RentalAgency("New Agency", "0987654321", "new@example.com");
        truck.setRentalAgency(newAgency);
        assertEquals(newAgency, truck.getRentalAgency());
    }

    @Test
    void isAvailable() {
        assertTrue(truck.isAvailable());
    }

    @Test
    void setAvailable() {
        truck.setAvailable(false);
        assertFalse(truck.isAvailable());
    }

    @Test
    void getColor() {
        assertEquals("Red", truck.getColor());
    }

    @Test
    void setColor() {
        truck.setColor("Blue");
        assertEquals("Blue", truck.getColor());
    }

    @Test
    void getHorsepower() {
        assertEquals(381, truck.getHorsepower());
    }

    @Test
    void setHorsepower() {
        truck.setHorsepower(400);
        assertEquals(400, truck.getHorsepower());
    }

    @Test
    void getTransmissionType() {
        assertEquals(Vehicle.TransmissionType.AUTOMATIC, truck.getTransmissionType());
    }

    @Test
    void setTransmissionType() {
        truck.setTransmissionType(Vehicle.TransmissionType.MANUAL);
        assertEquals(Vehicle.TransmissionType.MANUAL, truck.getTransmissionType());
    }

    @Test
    void getBaseRentalRate() {
        assertEquals(80, truck.getBaseRentalRate());
    }

    @Test
    void getCargoCapacity() {
        assertEquals(2000, truck.getCargoCapacity());
    }

    @Test
    void setCargoCapacity() {
        assertTrue(truck.setCargoCapacity(2500));
        assertEquals(2500, truck.getCargoCapacity());
    }

    @Test
    void hasTrailer() {
        assertTrue(truck.hasTrailer());
    }

    @Test
    void setHasTrailer() {
        truck.setHasTrailer(false);
        assertFalse(truck.hasTrailer());
    }

    @Test
    void calculateRentalCost() {
        assertEquals(210.0, truck.calculateRentalCost(1));
    }

    @Test
    void rent() {
        Customer customer = new Customer("John Doe", "9876543210", "john@example.com", "C1234", "LIC456");
        assertTrue(truck.rent(customer, 5));
        assertFalse(truck.isAvailable());
    }

    @Test
    void returnVehicle() {
        truck.setAvailable(false);
        assertTrue(truck.returnVehicle());
        assertTrue(truck.isAvailable());
    }

    @Test
    void isAvailableForRental() {
        assertTrue(truck.isAvailableForRental());
    }

    @Test
    void testToString() {
        String expected = "Truck{vehicleId='T123', manufacturer='Toyota', model='Tundra', isAvailable=true, color='Red', horsepower=381, transmissionType=AUTOMATIC, cargoCapacity=2000.0, hasTrailer=true}";
        assertEquals(expected, truck.toString());
    }

    @Test
    void testEquals() {
        Truck anotherTruck = new Truck("T123", "Toyota", "Tundra", rentalAgency, true, "Red", 381, Vehicle.TransmissionType.AUTOMATIC, 2000, true);
        assertEquals(truck, anotherTruck);
    }

    @Test
    void testHashCode() {
        Truck anotherTruck = new Truck("T123", "Toyota", "Tundra", rentalAgency, true, "Red", 381, Vehicle.TransmissionType.AUTOMATIC, 2000, true);
        assertEquals(truck.hashCode(), anotherTruck.hashCode());
    }
}