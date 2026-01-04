package parking_lot;

import parking_lot.entity.ParkingLot;
import parking_lot.entity.ParkingSpot;
import parking_lot.entity.Ticket;
import parking_lot.entity.Vehicle;
import parking_lot.enums.SpotStatus;
import parking_lot.enums.VehicleType;
import parking_lot.service.EntryGate;
import parking_lot.service.ExitGate;
import parking_lot.service.PricingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int vid=1;
    static int ticketid=1;

    static List <Ticket> ticketList;


    static public void displayParkingLot(ParkingLot parkingLot){

        System.out.println("Printing Parking lot");

        for (ParkingSpot parkingSpot: parkingLot.getParkingSpotList()){
            System.out.print("Spot ID: " + parkingSpot.getId());
            System.out.print(" X,y Cord: " + parkingSpot.getX() + "," + parkingSpot.getY());
            String status = "Vacant";
            String type = "4 Wheeler";

            if(parkingSpot.getSpotStatus()==SpotStatus.OCCUPIED) status="Occupied";
            if(parkingSpot.getVehicleType()==VehicleType.TWO_WHEELER) type="2 wheeler";
            System.out.print(" Spot ID: " + status);
            System.out.print(" Type:  " + type);
            System.out.println();
        }
    }

    static public void enterNewVehicle(EntryGate entryGate){

        System.out.println("Vehicle type 2 or 4 wheeler:");
        int type = sc.nextInt();

        Vehicle vehicle = new Vehicle();
        if(type==2){
            vehicle.setId(vid); vehicle.setVehicleType(VehicleType.TWO_WHEELER);
        }else {
            vehicle.setId(vid); vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
        }

        Ticket newTicket = entryGate.generateTicket(vehicle,ticketid);
        ticketid++;
        ticketList.add(newTicket);
    }

    static public void exitVechicle(ExitGate exitGate)
    {
        System.out.println("Vehicle ID To exit: ");
        int id = sc.nextInt();

        Ticket ticket = new Ticket();
        for(Ticket item: ticketList){
            if(item.getVehicle().getId()==id){
                ticket=item;
                break;
            }
        }

        exitGate.payment(ticket);

        ticketList.removeIf(obj -> obj.getId()==id);
    }

    public static void displayAllTickets(){
        System.out.println("Printing all tickets");

        for (Ticket item:ticketList){
            System.out.print(item.getId() + " " + item.getVehicle().getId() + " " + item.getDatetime().toString());
        }
    }

    public static void main(String [] args)
    {
        System.out.println("This is the driver class for parking lot LLD");

        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        parkingSpotList.add(new ParkingSpot(1,1,1, SpotStatus.VACANT, VehicleType.FOUR_WHEELER));
        parkingSpotList.add(new ParkingSpot(2,2,2, SpotStatus.VACANT, VehicleType.FOUR_WHEELER));
        parkingSpotList.add(new ParkingSpot(3,3,3, SpotStatus.VACANT, VehicleType.FOUR_WHEELER));
        parkingSpotList.add(new ParkingSpot(4,4,4, SpotStatus.VACANT, VehicleType.TWO_WHEELER));
        parkingSpotList.add(new ParkingSpot(5,5,5, SpotStatus.VACANT, VehicleType.TWO_WHEELER));

        ParkingLot parkingLot = new ParkingLot(parkingSpotList);
        EntryGate entryGate = new EntryGate(parkingLot,0,0);
        ExitGate exitGate = new ExitGate(new PricingService(),parkingLot);
        ticketList = new ArrayList<>();
        int option =0;

        while(option!=5) {
            System.out.println("1. Display parking Lot\n2. To enter new Vehicle\n" +
                    "3 To exit particular vehicle\n4.To Display all tickets\n5. To Exit ");
            option = sc.nextInt();
            if (option == 1) {
                displayParkingLot(parkingLot);
            } else if (option == 2) {
                enterNewVehicle(entryGate);
            } else if (option == 3) {
                exitVechicle(exitGate);
            } else if (option == 4) {
                displayAllTickets();
            } else {
                break;
            }
        }

    }
}
