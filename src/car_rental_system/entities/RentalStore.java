package car_rental_system.entities;

import car_rental_system.enums.VehicleStatus;
import car_rental_system.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RentalStore {
    int id;
    String name;
    Location location;
    Map<String,Vehicle> vehicleMap;

    public RentalStore(int id, String name, Location location) {
        this.location=location;
        this.id=id;
        this.name=name;
    }


    public Vehicle getVehicle(String registrationNumber){
        return vehicleMap.get(registrationNumber);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getRegistrationNumber(),vehicle);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public RentalStore(int id, String name, Location location, Map<String, Vehicle> vehicleMap) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicleMap = vehicleMap;
    }

    public RentalStore(Location location, Map<String, Vehicle> vehicleMap) {
        this.location = location;
        this.vehicleMap = vehicleMap;
    }

    public List<Vehicle> getVehicleList()
    {
        List<Vehicle> vehicleList = new ArrayList<>();
        for(Map.Entry<String,Vehicle> entry: vehicleMap.entrySet())
        {
            vehicleList.add(entry.getValue());
        }
        return vehicleList;
    }

    public VehicleStatus getVehicleStatus(Vehicle vehicle)
    {
        return vehicleMap.get(vehicle.registrationNumber).getVehicleStatus();
    }


}
