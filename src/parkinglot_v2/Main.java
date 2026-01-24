package parkinglot_v2;

import parkinglot_v2.entity.ParkingFloor;
import parkinglot_v2.entity.ParkingSpot;
import parkinglot_v2.entity.ParkingTicket;
import parkinglot_v2.enums.VehicleSize;
import parkinglot_v2.factory.Vehicle;
import parkinglot_v2.factory.VehicleFactory;
import parkinglot_v2.strategy.fee.HourlyFeeStrategy;

public class Main {

    public static void main(String[] args)
    {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle bike =vehicleFactory.createVehicle("1234","BIKE");
        Vehicle car = vehicleFactory.createVehicle("3456","CAR");
        Vehicle truck = vehicleFactory.createVehicle("1222","TRUCK");


        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingFloor floor2 = new ParkingFloor(2);
        floor1.addSpot(new ParkingSpot(1,false, VehicleSize.SMALL));
        floor1.addSpot(new ParkingSpot(1,false, VehicleSize.MEDIUM));
        floor1.addSpot(new ParkingSpot(1,false, VehicleSize.LARGE));
        floor1.addSpot(new ParkingSpot(1,false, VehicleSize.XL));
        floor2.addSpot(new ParkingSpot(1,false, VehicleSize.SMALL));
        floor2.addSpot(new ParkingSpot(1,false, VehicleSize.MEDIUM));
        floor2.addSpot(new ParkingSpot(1,false, VehicleSize.LARGE));
        floor2.addSpot(new ParkingSpot(1,false, VehicleSize.XL));

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);


        ParkingTicket pt1 = new ParkingTicket("1",bike,parkingLot.getParkingFloorList().get(0),10,new HourlyFeeStrategy());
        ParkingTicket pt2 = new ParkingTicket("2",car,parkingLot.getParkingFloorList().get(0),12,new HourlyFeeStrategy());

        parkingLot.parkVehicle(pt1);
        parkingLot.parkVehicle(pt2);

        int fee1=parkingLot.unParkVehicle(pt1,20);
        int fee2=parkingLot.unParkVehicle(pt2,21);


    }
}
