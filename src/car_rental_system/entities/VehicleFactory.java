package car_rental_system.entities;

import car_rental_system.enums.VehicleType;

public class VehicleFactory {

    public static Vehicle createVehicle(String registrationNumber, VehicleType vehicleType, String model, Double basePrice){

        switch (vehicleType) {
            case NORMAL:
                return new NormalVehicle(registrationNumber, vehicleType, model, 100.00);
            case SUV:
                return new SUVVechicle(registrationNumber, vehicleType, model, 150.00);
            case LUXURY:
                return new LuxuryVehicle(registrationNumber, vehicleType, model, 200.00);
            default:
                throw new IllegalArgumentException("Unsupported Vehicle Type: " + vehicleType);
        }

    }
}
