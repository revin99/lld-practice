package parking_lot.service;

import parking_lot.entity.ParkingLot;
import parking_lot.entity.ParkingSpot;
import parking_lot.entity.Ticket;
import parking_lot.entity.Vehicle;
import parking_lot.enums.SpotStatus;

import java.util.Date;
import java.util.List;

public class EntryGate {
    ParkingLot parkingLot;

    List <Ticket> TicketList;

    private int x;
    private int y;
    public EntryGate(ParkingLot parkingLot, int x, int y){
        this.parkingLot=parkingLot;
        this.x=x;
        this.y=y;
    }

    public int getNearestParkingSpot(Vehicle vehicle)
    {
        List<ParkingSpot> parkingSpotList = parkingLot.getParkingSpotList();
        int mxdist = 100000000;

        int id=-1;
        for(ParkingSpot item: parkingSpotList)
        {
            int x1 = item.getX(); int y1 = item.getY();
            if(item.getSpotStatus()== SpotStatus.VACANT && item.getVehicleType()==vehicle.getVehicleType()){
                int dist = (x1-x)*(x1-x) + (y1-y)*(y1-y);
                if (dist<mxdist){
                    id = item.getId();
                    mxdist=dist;
                }
            }
        }
        return id;
    }
    public Ticket generateTicket(Vehicle vehicle, int ticketId)
    {
        int parkingSpotId = getNearestParkingSpot(vehicle);
        if (parkingSpotId==-1){
            System.out.println("No vacant spots available");
        }else{
            List<ParkingSpot> parkingSpotList = parkingLot.getParkingSpotList();
            ParkingSpot parkingSpot = new ParkingSpot();
            for (ParkingSpot item:parkingSpotList){
                if(item.getId()==parkingSpotId){
                    parkingSpot=item;
                    item.setSpotStatus(SpotStatus.OCCUPIED);
                    System.out.println("Parking spot is made occuppied: " + item.getId() );
                    break;
                }
            }
            parkingLot.setParkingSpotList(parkingSpotList);
            Ticket ticket = new Ticket(ticketId,vehicle, new Date(),parkingSpot,"Valid");
            return ticket;
        }
        return new Ticket(ticketId,null,null,null,"Invalid");
    }

}
