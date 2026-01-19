package atm_v2.entity;

import java.util.HashMap;
import java.util.Map;

public class Account {

    private int accountId;
    private int money;
    private String accountHolderName;
    private Map<String,Integer> cardPinMapping;


    public Account(int accountId, int money, String accountHolderName) {
        this.accountId = accountId;
        this.money = money;
        this.accountHolderName = accountHolderName;
        this.cardPinMapping = new HashMap<>();
    }

    public void addCard(String cardNumber, int pin){
        cardPinMapping.put(cardNumber,pin);
    }

    public void removeCard(String cardNumber){
        cardPinMapping.remove(cardNumber);
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Map<String, Integer> getCardPinMapping() {
        return cardPinMapping;
    }

    public void setCardPinMapping(Map<String, Integer> cardPinMapping) {
        this.cardPinMapping = cardPinMapping;
    }
}
