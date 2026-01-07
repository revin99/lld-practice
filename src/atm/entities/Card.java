package atm.entities;

public class Card {

    String cardNumber;
    int pinNumber;

    public Card(String cardNumber, int pinNumber) {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
}
