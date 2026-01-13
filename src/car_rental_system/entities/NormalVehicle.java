package car_rental_system.entities;

import car_rental_system.enums.VehicleStatus;
import car_rental_system.enums.VehicleType;

public class NormalVehicle extends Vehicle{

    Double priceMultipler = 1.25;

    public NormalVehicle(String registrationNumber, VehicleType vehicleType, String model, Double basePrice) {
        super(registrationNumber, vehicleType, model, basePrice);
    }

    public Double calculateRentalFee(int days)
    {
        return getBasePrice()*priceMultipler*days;
    }

}
