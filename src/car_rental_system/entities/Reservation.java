package car_rental_system.entities;

import car_rental_system.enums.ReservationStatus;
import car_rental_system.enums.VehicleStatus;

import java.util.Date;

public class Reservation {

    int id;
    User user;
    Vehicle vehicle;
    RentalStore pickUpStore;
    RentalStore dropStore;
    Date startDate;
    Date endDate;
    ReservationStatus reservationStatus;
    private double totalAmount;

    public Reservation(int id, User user, Vehicle vehicle, RentalStore pickUpStore, RentalStore dropStore, Date startDate, Date endDate) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.pickUpStore = pickUpStore;
        this.dropStore = dropStore;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationStatus = ReservationStatus.PENDING;
        long diffInMillies = endDate.getTime() - startDate.getTime();
        int days = (int) (diffInMillies / (1000 * 60 * 60 * 24)) + 1;
        this.totalAmount = vehicle.calculateRentalFee(days);
    }

    public void confirmReservation() {
        if (reservationStatus == ReservationStatus.PENDING) {
            reservationStatus = ReservationStatus.CONFIRMED;
            vehicle.setVehicleStatus(VehicleStatus.RESERVED);
        }
    }

    public void startRental() {
        if (reservationStatus == ReservationStatus.CONFIRMED) {
            reservationStatus = ReservationStatus.IN_PROGRESS;
            vehicle.setVehicleStatus(VehicleStatus.RENTED);
        }
    }

    public void completeRental() {
        if (reservationStatus == ReservationStatus.IN_PROGRESS) {
            reservationStatus = ReservationStatus.COMPLETED;
            vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
        }
    }

    public void cancelReservation() {
        if (reservationStatus == ReservationStatus.PENDING
                || reservationStatus == ReservationStatus.CONFIRMED) {
            reservationStatus = ReservationStatus.CANCELLED;
            vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public RentalStore getPickUpStore() {
        return pickUpStore;
    }

    public void setPickUpStore(RentalStore pickUpStore) {
        this.pickUpStore = pickUpStore;
    }

    public RentalStore getDropStore() {
        return dropStore;
    }

    public void setDropStore(RentalStore dropStore) {
        this.dropStore = dropStore;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
