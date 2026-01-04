package parking_lot.service;

import parking_lot.entity.Ticket;
import parking_lot.enums.VehicleType;

import java.util.Date;

public class PricingService {

    public int calculateFee(Ticket ticket)
    {
        Date startTime = ticket.getDatetime();
        Date endTime = new Date();

        long seconds = (endTime.getTime() - startTime.getTime())/1000;
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        long cost=0;
        if(vehicleType==VehicleType.FOUR_WHEELER){
            cost = seconds*10;
            System.out.println("Cost is " + cost + " and Vtype is 4 wheeler ");
        }else {
            cost = seconds*5;
            System.out.println("Cost is " + cost + " and Vtype is 2 wheeler ");
        }

        return (int) cost;
    }
}
