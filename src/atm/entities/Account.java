package atm.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

    String accountNumber;
    int bankBalance;
    Map<String,Card> mapCards;

    public Account(String accountNumber, int bankBalance) {
        this.accountNumber = accountNumber;
        this.bankBalance = bankBalance;
        this.mapCards = new HashMap<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }

    public Map<String,Card> getMapCards() {
        return mapCards;
    }

    public void setCardList(Map<String,Card> mapCards) {
        this.mapCards = mapCards;
    }

    public synchronized void addMoney(int addAmount)
    {
        this.bankBalance+=addAmount;
    }

    public synchronized boolean  removeMoney(int removeMoney)
    {
        if(this.bankBalance>=removeMoney) {
            this.bankBalance -= removeMoney;
            return true;
        }
        return false;
    }
}
