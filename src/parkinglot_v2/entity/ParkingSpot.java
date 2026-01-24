package parkinglot_v2.entity;

import parkinglot_v2.enums.VehicleSize;

public class ParkingSpot {
    private int id;
    private boolean occupied;
    VehicleSize vehicleSize;

    public ParkingSpot(int id, boolean occupied, VehicleSize vehicleSize) {
        this.id = id;
        this.occupied = occupied;
        this.vehicleSize = vehicleSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }
}
