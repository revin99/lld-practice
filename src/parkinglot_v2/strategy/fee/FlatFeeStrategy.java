package parkinglot_v2.strategy.fee;

import parkinglot_v2.entity.ParkingTicket;
import parkinglot_v2.enums.VehicleSize;

public class FlatFeeStrategy implements FeeStrategy{
    @Override
    public int calculateFee(ParkingTicket parkingTicket) {

        int multipler=20;
        VehicleSize vehicleSize = parkingTicket.getVehicle().getVehicleSize();
        if(vehicleSize==VehicleSize.MEDIUM) multipler*=1.25;
        else if (vehicleSize==VehicleSize.LARGE) {multipler*=1.5;}
        else if(vehicleSize==VehicleSize.XL){multipler*=2;}

        return multipler;
    }
}
