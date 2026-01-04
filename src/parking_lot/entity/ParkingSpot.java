package parking_lot.entity;

import parking_lot.enums.SpotStatus;
import parking_lot.enums.VehicleType;

public class ParkingSpot {

    int id;
    private int x;
    private int y;
    private SpotStatus spotStatus;
    private VehicleType vehicleType;

    public ParkingSpot(int id,int x, int y, SpotStatus spotStatus, VehicleType vehicleType){
        this.x=x;
        this.y=y;
        this.spotStatus=spotStatus;
        this.vehicleType=vehicleType;
        this.id=id;
    }

    public ParkingSpot(){

    }

    public int getId() {
        return id;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public SpotStatus getSpotStatus(){
        return spotStatus;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType=vehicleType;
    }
}
