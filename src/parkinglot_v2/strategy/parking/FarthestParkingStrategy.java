package parkinglot_v2.strategy.parking;

import parkinglot_v2.entity.ParkingFloor;
import parkinglot_v2.entity.ParkingSpot;
import parkinglot_v2.factory.Vehicle;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class FarthestParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot getSpot(ParkingFloor parkingFloor, Vehicle vehicle) {

        Map<Integer,ParkingSpot> map = new TreeMap<>(Collections.reverseOrder());
        map.putAll(parkingFloor.getParkingSpotMap());
        return parkingFloor.findSpot(map,vehicle.getVehicleSize());
    }
}
