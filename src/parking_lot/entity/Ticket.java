package parking_lot.entity;

import java.util.Date;

public class Ticket {

    int id;
    Vehicle vehicle;
    Date datetime;
    ParkingSpot parkingSpot;
    String validity;

    public Ticket(int id,Vehicle vehicle, Date datetime, ParkingSpot parkingSpot, String validity){
        this.id=id;
        this.vehicle=vehicle;
        this.datetime=datetime;
        this.parkingSpot=parkingSpot;
        this.validity=validity;
    }
    public Ticket(){

    }

    public Date getDatetime() {
        return datetime;
    }

    public String getValidity() {
        return validity;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public int getId() {
        return id;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void setId(int id) {
        this.id = id;
    }
}
