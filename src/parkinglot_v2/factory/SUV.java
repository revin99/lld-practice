package parkinglot_v2.factory;

import parkinglot_v2.enums.VehicleSize;

public class SUV extends Vehicle{
    public SUV(String licenseNumber) {
        super(licenseNumber, VehicleSize.LARGE);
    }
}
