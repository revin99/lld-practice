package parkinglot_v2.strategy.fee;

import parkinglot_v2.entity.ParkingTicket;
import parkinglot_v2.enums.VehicleSize;

public class HourlyFeeStrategy implements FeeStrategy{

    @Override
    public int calculateFee(ParkingTicket parkingTicket) {

        int startTime = parkingTicket.getStartTime();
        int endTime = parkingTicket.getEndTime();

        int multipler=10;
        VehicleSize vehicleSize = parkingTicket.getVehicle().getVehicleSize();
        if(vehicleSize==VehicleSize.MEDIUM) multipler*=1.25;
        else if (vehicleSize==VehicleSize.LARGE) {multipler*=1.5;}
        else if(vehicleSize==VehicleSize.XL){multipler*=2;}

        return (endTime-startTime)*multipler;
    }
}
