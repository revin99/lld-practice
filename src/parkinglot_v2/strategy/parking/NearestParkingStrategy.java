package parkinglot_v2.strategy.parking;

import parkinglot_v2.entity.ParkingFloor;
import parkinglot_v2.entity.ParkingSpot;
import parkinglot_v2.factory.Vehicle;

public class NearestParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot getSpot(ParkingFloor parkingFloor, Vehicle vehicle) {

        return parkingFloor.findSpot(parkingFloor.getParkingSpotMap(),vehicle.getVehicleSize());
    }
}
