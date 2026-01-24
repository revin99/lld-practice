package parkinglot_v2.factory;

public class VehicleFactory {

    public Vehicle createVehicle(String licenseNumber, String type)
    {
        if(type.equals("BIKE")){
            return new Bike(licenseNumber);
        }else if(type.equals("CAR")){
            return new Car(licenseNumber);
        }else if(type.equals("SUV")){
            return new SUV(licenseNumber);
        }else if(type.equals("TRUCK")){
            return new Truck(licenseNumber);
        }else {
            throw new IllegalArgumentException("Illegal vehicle type");
        }


    }
}
