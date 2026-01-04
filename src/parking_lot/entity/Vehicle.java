package parking_lot.entity;

import parking_lot.enums.VehicleType;

public class Vehicle {
    private int id;
    VehicleType vehicleType;

    public Vehicle(int id, VehicleType vehicleType){
        this.id = id;
        this.vehicleType=vehicleType;
    }
    public Vehicle(){

    }
    public int getId(){
        return id;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public void setId(int id) {
        this.id = id;
    }
}
