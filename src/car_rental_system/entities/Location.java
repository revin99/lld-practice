package car_rental_system.entities;

public class Location {

    String address;
    String city;
    String pincode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Location(String address, String city, String pincode) {
        this.address = address;
        this.city = city;
        this.pincode = pincode;
    }
}
