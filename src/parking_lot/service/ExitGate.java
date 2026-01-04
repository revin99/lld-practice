package parking_lot.service;

import parking_lot.entity.ParkingLot;
import parking_lot.entity.ParkingSpot;
import parking_lot.entity.Ticket;
import parking_lot.enums.SpotStatus;

import java.util.List;
import java.util.Scanner;

public class ExitGate {

    Scanner sc = new Scanner(System.in);
    PricingService pricingService;
    ParkingLot parkingLot;
    public ExitGate(PricingService pricingService, ParkingLot parkingLot){
        this.pricingService=pricingService;
        this.parkingLot = parkingLot;
    }


    public void payment(Ticket ticket){

        int cost = pricingService.calculateFee(ticket);

        System.out.println("Press 1 to pay the price");
        int option = sc.nextInt();

        int parkingSpotId = ticket.getParkingSpot().getId();
        List<ParkingSpot> parkingSpotList = parkingLot.getParkingSpotList();

        for(ParkingSpot item: parkingSpotList){
            if(item.getId()==parkingSpotId){
                item.setSpotStatus(SpotStatus.VACANT);
                System.out.println("Parking spot is made empty" + item.getId() );
            }
        }
        parkingLot.setParkingSpotList(parkingSpotList);
    }
}
