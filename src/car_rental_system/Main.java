package car_rental_system;

import car_rental_system.entities.*;
import car_rental_system.enums.VehicleType;

import java.util.Date;

public class Main {

    public static void main(String[] args)
    {
        RentalSystem rentalSystem = RentalSystem.getInstance();

        // Create rental stores
        RentalStore store1 = new RentalStore(
                1, "Downtown Rentals", new Location("123 Main St", "New York",  "10001"));
        RentalStore store2 = new RentalStore(
                2, "Airport Rentals", new Location("456 Airport Rd", "Los Angeles", "90045"));
        rentalSystem.addStore(store1);
        rentalSystem.addStore(store2);

        // Create vehicles using Factory Pattern
        Vehicle economyCar = VehicleFactory.createVehicle("1234",VehicleType.NORMAL,"BMW",50.0);
        Vehicle luxuryCar = VehicleFactory.createVehicle("4567",VehicleType.LUXURY,"MERC",100.00);
        Vehicle suvCar = VehicleFactory.createVehicle("6789",VehicleType.SUV,"JEEP",125.00);

        // Add vehicles to stores
        store1.addVehicle(economyCar);
        store1.addVehicle(luxuryCar);
        store2.addVehicle(suvCar);

        // Register user
        User user1 = new User(123, "ABC");
        User user2 = new User(345 , "BCD");


        rentalSystem.registerUser(user1);
        rentalSystem.registerUser(user2);

        // Create reservations
        Reservation reservation1 = rentalSystem.createReservation(user1.getId(), economyCar.getRegistrationNumber(),
                store1.getId(), store1.getId(), new Date(2025 - 1900, 4, 1),
                new Date(2025 - 1900, 5, 15));
    }
}
