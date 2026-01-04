package parking_lot.entity;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpotList;

    public ParkingLot(List<ParkingSpot> parkingSpotList){
        this.parkingSpotList=parkingSpotList;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }
}
