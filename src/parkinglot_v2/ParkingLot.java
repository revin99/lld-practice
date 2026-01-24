package parkinglot_v2;

import parkinglot_v2.entity.ParkingFloor;
import parkinglot_v2.entity.ParkingSpot;
import parkinglot_v2.entity.ParkingTicket;
import parkinglot_v2.factory.Truck;
import parkinglot_v2.factory.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    public static ParkingLot instance;
    private List<ParkingFloor> parkingFloorList;
    private List<ParkingTicket> parkingTickets;


    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public List<ParkingTicket> getParkingTickets() {
        return parkingTickets;
    }

    public void setParkingTickets(List<ParkingTicket> parkingTickets) {
        this.parkingTickets = parkingTickets;
    }

    private ParkingLot(){
        this.parkingFloorList=new ArrayList<>();
        this.parkingTickets=new ArrayList<>();
    }

    public static ParkingLot getInstance()
    {
        if(instance==null){
            instance=new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor parkingFloor){
        parkingFloorList.add(parkingFloor);
    }

    public void parkVehicle(ParkingTicket parkingTicket)
    {
        Vehicle vehicle = parkingTicket.getVehicle();
        ParkingFloor floor = parkingTicket.getParkingFloor();
        ParkingSpot spot = parkingTicket.getParkingStrategy().getSpot(floor,vehicle);
        parkingTicket.setParkingSpot(spot);
        floor.setSpot(spot.getId());

    }

    public int getFee(ParkingTicket parkingTicket){

        return parkingTicket.getFeeStrategy().calculateFee(parkingTicket);
    }

    public int unParkVehicle(ParkingTicket parkingTicket, int endtime)
    {
        Vehicle vehicle = parkingTicket.getVehicle();
        ParkingFloor floor = parkingTicket.getParkingFloor();
        Map<Integer,ParkingSpot> map=floor.getParkingSpotMap();
        ParkingSpot spot = parkingTicket.getParkingSpot();

        spot.setOccupied(false);
        parkingTickets.remove(parkingTicket);

        parkingTicket.setEndTime(endtime);
        return getFee(parkingTicket);
    }
}
