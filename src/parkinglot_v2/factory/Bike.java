package parkinglot_v2.factory;

import parkinglot_v2.enums.VehicleSize;

public class Bike extends Vehicle{

    public Bike(String licenseNumber) {
        super(licenseNumber, VehicleSize.SMALL);
    }
}
