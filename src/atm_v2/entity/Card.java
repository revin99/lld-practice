package atm_v2.entity;

public class Card {

    private String cardNumber;
    private Account account; //account linked to this card

    public Card(String cardNumber, Account account) {
        this.cardNumber = cardNumber;
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
