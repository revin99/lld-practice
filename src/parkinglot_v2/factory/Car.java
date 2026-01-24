package parkinglot_v2.factory;

import parkinglot_v2.enums.VehicleSize;

public class Car extends Vehicle{
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleSize.MEDIUM);
    }
}
