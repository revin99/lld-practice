package parkinglot_v2.factory;

import parkinglot_v2.enums.VehicleSize;

public class Truck extends Vehicle{
    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleSize.XL);
    }
}
