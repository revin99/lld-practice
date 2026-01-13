package car_rental_system.entities;

import car_rental_system.enums.VehicleStatus;
import car_rental_system.enums.VehicleType;

public abstract class Vehicle {

    String registrationNumber;
    VehicleType vehicleType;
    VehicleStatus vehicleStatus;
    String model;
    Double basePrice;

    public Vehicle(String registrationNumber, VehicleType vehicleType, String model, Double basePrice) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
        this.model = model;
        this.basePrice = basePrice;
    }

    public abstract Double calculateRentalFee(int days);

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }
}
