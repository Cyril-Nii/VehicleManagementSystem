package com.vms_sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TruckTest {

    private Truck truck1;
    private RentalAgency rentalAgency1;

    @BeforeEach
    public void setUp() {
        rentalAgency1 = new RentalAgency();
        truck1 = new Truck(
            "T0001",           // vehicleId
            "Chevrolet",       // manufacturer
            "S-10",            // model
            rentalAgency1,     // rentalAgency
            true,              // isAvailable
            "Yellow",          // color
            450,               // horsepower
            TransmissionType.AUTOMATIC, // transmissionType
            5000.0,            // cargoCapacity
            false              // hasTrailer
        );
    }

    @Test
    public void testGetters() {
        assertEquals("T0001", truck1.getVehicleId());
        assertEquals("Chevrolet", truck1.getManufacturer());
        assertEquals("S-10", truck1.getModel());
        assertEquals(rentalAgency1, truck1.getRentalAgency());
        assertTrue(truck1.isAvailable());
        assertEquals("Yellow", truck1.getColor());
        assertEquals(450, truck1.getHorsepower());
        assertEquals(TransmissionType.AUTOMATIC, truck1.getTransmissionType());
        assertEquals(5000.0, truck1.getCargoCapacity());
        assertFalse(truck1.hasTrailer());
    }

    @Test
    public void testSetters() {
        truck1.setCargoCapacity(6000.0);
        assertEquals(6000.0, truck1.getCargoCapacity());

        truck1.setHasTrailer(true);
        assertTrue(truck1.hasTrailer());
    }

    @Test
    public void testInvalidCargoCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Truck("T0002", "Ford", "F-150", rentalAgency1, true, "Blue", 400, TransmissionType.MANUAL, -1000.0, true);
        });

        assertFalse(truck1.setCargoCapacity(-100.0));
        assertEquals(5000.0, truck1.getCargoCapacity());
    }

    @Test
    public void testAvailability() {
        truck1.setAvailable(false);
        assertFalse(truck1.isAvailable());

        truck1.setAvailable(true);
        assertTrue(truck1.isAvailable());
    }

    @Test
    public void testToString() {
        String expected = "Truck{vehicleId='T0001', manufacturer='Chevrolet', model='S-10', isAvailable=true, color='Yellow', horsepower=450, transmissionType=AUTOMATIC, cargoCapacity=5000.0, hasTrailer=false}";
        assertEquals(expected, truck1.toString());
    }

    @Test
    public void testEquals() {
        Truck sameTruck = new Truck(
            "T0001",           // vehicleId
            "Chevrolet",       // manufacturer
            "S-10",            // model
            rentalAgency1,     // rentalAgency
            true,              // isAvailable
            "Yellow",          // color
            450,               // horsepower
            TransmissionType.AUTOMATIC, // transmissionType
            5000.0,            // cargoCapacity
            false              // hasTrailer
        );

        Truck differentTruck = new Truck(
            "T0002",           // vehicleId
            "Ford",            // manufacturer
            "F-150",           // model
            rentalAgency1,     // rentalAgency
            true,              // isAvailable
            "Blue",            // color
            400,               // horsepower
            TransmissionType.MANUAL, // transmissionType
            6000.0,            // cargoCapacity
            true               // hasTrailer
        );

        assertTrue(truck1.equals(sameTruck));
        assertFalse(truck1.equals(differentTruck));
    }

    @Test
    public void testHashCode() {
        Truck sameTruck = new Truck(
            "T0001",           // vehicleId
            "Chevrolet",       // manufacturer
            "S-10",            // model
            rentalAgency1,     // rentalAgency
            true,              // isAvailable
            "Yellow",          // color
            450,               // horsepower
            TransmissionType.AUTOMATIC, // transmissionType
            5000.0,            // cargoCapacity
            false              // hasTrailer
        );

        assertEquals(truck1.hashCode(), sameTruck.hashCode());
    }
}