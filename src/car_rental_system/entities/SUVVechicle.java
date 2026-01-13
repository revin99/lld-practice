package car_rental_system.entities;

import car_rental_system.enums.VehicleType;

public class SUVVechicle extends Vehicle{

    Double priceMultipler = 1.50;

    public SUVVechicle(String registrationNumber, VehicleType vehicleType, String model, Double basePrice) {
        super(registrationNumber, vehicleType, model, basePrice);
    }

    public Double calculateRentalFee(int days)
    {
        return getBasePrice()*priceMultipler*days;
    }

}
