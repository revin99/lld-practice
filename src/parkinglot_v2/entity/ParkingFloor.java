package parkinglot_v2.entity;

import parkinglot_v2.enums.VehicleSize;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ParkingFloor {

    private int floor_number;
    private Map<Integer,ParkingSpot> parkingSpotMap;

    public ParkingSpot findSpot(Map<Integer,ParkingSpot> parkingSpotMap, VehicleSize vehicleSize)
    {
        for(Map.Entry<Integer,ParkingSpot> entry:parkingSpotMap.entrySet())
        {
            if(!entry.getValue().isOccupied() &&
                    entry.getValue().vehicleSize==vehicleSize){ //the first spot which is vacant and of same size return it
                return entry.getValue();
            }
        }
        return null;
    }

    public void setSpot(Integer spotId){
        ParkingSpot spot = parkingSpotMap.get(spotId);
        spot.setOccupied(true);
        parkingSpotMap.put(spotId,spot);
    }

    public void addSpot(ParkingSpot spot){
        this.parkingSpotMap.put(spot.getId(),spot);
    }
    public ParkingFloor(int floor_number) {
        this.floor_number = floor_number;
        this.parkingSpotMap = new TreeMap<>();
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }

    public Map<Integer, ParkingSpot> getParkingSpotMap() {
        return parkingSpotMap;
    }

    public void setParkingSpotMap(Map<Integer, ParkingSpot> parkingSpotMap) {
        this.parkingSpotMap = parkingSpotMap;
    }
}
