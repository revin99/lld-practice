package car_rental_system.entities;

import car_rental_system.enums.VehicleType;

public class LuxuryVehicle extends Vehicle{

    Double priceMultipler = 2.00;

    public LuxuryVehicle(String registrationNumber, VehicleType vehicleType, String model, Double basePrice) {
        super(registrationNumber, vehicleType, model, basePrice);
    }

    public Double calculateRentalFee(int days)
    {
        return getBasePrice()*priceMultipler*days;
    }

}
