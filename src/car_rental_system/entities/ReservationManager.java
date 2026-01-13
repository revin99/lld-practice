package car_rental_system.entities;

import car_rental_system.enums.ReservationStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationManager {

    Map<Integer,Reservation> reservationMap;
    int reservationId;

    public ReservationManager() {
        this.reservationMap = new HashMap<>();
        this.reservationId = 1;
    }

    public Reservation createReservation(User user, Vehicle vehicle, RentalStore pickUpStore,
                                  RentalStore dropStore, Date startDate, Date endDate){

        Reservation reservation = new Reservation(reservationId++,user,vehicle,pickUpStore,dropStore,startDate,endDate);
        reservationMap.put(reservation.getId(),reservation);
        user.addReservation(reservation);

        return reservation;
    }
    public Reservation getReservation(Integer id)
    {
        return reservationMap.get(id);
    }

    public void confirmReservation(int reservationId){
        Reservation reservation = reservationMap.get(reservationId);
        if(reservation!=null){
            reservation.confirmReservation();
        }
    }

    public void startRental(int reservationId) {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null) {
            reservation.startRental();
        }
    }

    public void completeRental(int reservationId) {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null) {
            reservation.completeRental();
        }
    }

    public void cancelReservation(int reservationId) {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null) {
            reservation.cancelReservation();
        }
    }

    public Map<Integer, Reservation> getReservationMap() {
        return reservationMap;
    }

    public void setReservationMap(Map<Integer, Reservation> reservationMap) {
        this.reservationMap = reservationMap;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
}
