package parkinglot_v2.entity;

import parkinglot_v2.factory.Vehicle;
import parkinglot_v2.strategy.fee.FeeStrategy;
import parkinglot_v2.strategy.parking.NearestParkingStrategy;
import parkinglot_v2.strategy.parking.ParkingStrategy;

public class ParkingTicket {

    private String ticketId;
    private Vehicle vehicle;
    private ParkingFloor parkingFloor;
    private ParkingSpot parkingSpot;
    private int startTime;
    private int endTime;

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    FeeStrategy feeStrategy;
    ParkingStrategy parkingStrategy;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingFloor parkingFloor, int startTime, FeeStrategy feeStrategy) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingFloor = parkingFloor;
        this.startTime = startTime;
        this.feeStrategy = feeStrategy;
        this.parkingStrategy=new NearestParkingStrategy();
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public FeeStrategy getFeeStrategy() {
        return feeStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }
}
