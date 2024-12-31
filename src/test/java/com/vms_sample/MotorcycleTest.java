package com.vms_sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotorcycleTest {

    private Motorcycle motorcycle;
    private RentalAgency rentalAgency;

    @BeforeEach
    public void setUp() {
        rentalAgency = new RentalAgency();
        motorcycle = new Motorcycle(
            "M001",              // vehicleId
            "Royal Enfield",     // manufacturer
            "Classic 350",       // model
            rentalAgency,        // rentalAgency
            true,                // isAvailable
            "Black",             // color
            20,                  // horsepower
            TransmissionType.MANUAL, // transmissionType
            350.0                // engineCapacity
        );
    }

    @Test
    public void testGetters() {
        assertEquals("M001", motorcycle.getVehicleId());
        assertEquals("Royal Enfield", motorcycle.getManufacturer());
        assertEquals("Classic 350", motorcycle.getModel());
        assertEquals(rentalAgency, motorcycle.getRentalAgency());
        assertTrue(motorcycle.isAvailable());
        assertEquals("Black", motorcycle.getColor());
        assertEquals(20, motorcycle.getHorsepower());
        assertEquals(TransmissionType.MANUAL, motorcycle.getTransmissionType());
        assertEquals(350.0, motorcycle.getEngineCapacity());
    }

    @Test
    public void testSetters() {
        motorcycle.setColor("Red");
        assertEquals("Red", motorcycle.getColor());

        motorcycle.setHorsepower(25);
        assertEquals(25, motorcycle.getHorsepower());

        motorcycle.setTransmissionType(TransmissionType.AUTOMATIC);
        assertEquals(TransmissionType.AUTOMATIC, motorcycle.getTransmissionType());

        motorcycle.setEngineCapacity(500.0);
        assertEquals(500.0, motorcycle.getEngineCapacity());
    }

    @Test
    public void testEquals() {
        Motorcycle sameMotorcycle = new Motorcycle(
            "M001",              // vehicleId
            "Royal Enfield",     // manufacturer
            "Classic 350",       // model
            rentalAgency,        // rentalAgency
            true,                // isAvailable
            "Black",             // color
            20,                  // horsepower
            TransmissionType.MANUAL, // transmissionType
            350.0                // engineCapacity
        );

        Motorcycle differentMotorcycle = new Motorcycle(
            "M002",              // vehicleId
            "Harley Davidson",   // manufacturer
            "Street 750",        // model
            rentalAgency,        // rentalAgency
            true,                // isAvailable
            "Black",             // color
            50,                  // horsepower
            TransmissionType.MANUAL, // transmissionType
            750.0                // engineCapacity
        );

        assertTrue(motorcycle.equals(sameMotorcycle));
        assertFalse(motorcycle.equals(differentMotorcycle));
    }

    @Test
    public void testHashCode() {
        Motorcycle sameMotorcycle = new Motorcycle(
            "M001",              // vehicleId
            "Royal Enfield",     // manufacturer
            "Classic 350",       // model
            rentalAgency,        // rentalAgency
            true,                // isAvailable
            "Black",             // color
            20,                  // horsepower
            TransmissionType.MANUAL, // transmissionType
            350.0                // engineCapacity
        );

        assertEquals(motorcycle.hashCode(), sameMotorcycle.hashCode());
    }

    @Test
    public void testAvailability() {
        motorcycle.setAvailable(false);
        assertFalse(motorcycle.isAvailable());

        motorcycle.setAvailable(true);
        assertTrue(motorcycle.isAvailable());
    }
}