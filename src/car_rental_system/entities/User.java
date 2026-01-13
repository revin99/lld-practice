package car_rental_system.entities;

import java.util.List;

public class User {
    int id;
    String name;
    List<Reservation> reservations;

    public User(int iD, String name) {
        this.id=iD;
        this.name=name;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void deleteReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
