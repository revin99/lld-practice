package parkinglot_v2.strategy.fee;

import parkinglot_v2.entity.ParkingTicket;
import parkinglot_v2.enums.VehicleSize;

public interface FeeStrategy {

    public int calculateFee(ParkingTicket parkingTicket);
}
