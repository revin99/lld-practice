package atm.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    Map<String,Account> accounts = new ConcurrentHashMap<>();
    Map<String,Card> cards = new ConcurrentHashMap<>();
    Map<Card,Account> cardAccountMap = new ConcurrentHashMap<>();

    public Bank(){
        Account account1 = createAccount("123456789",10000);
        Account account2 = createAccount("987654321",50000);

        Card card1 = createCard("112233",1234);
        Card card2 = createCard("223344",2345);

        linkCardToAccount(card1,account1);
        linkCardToAccount(card2,account2);

    }
    public Account createAccount(String accountNumber, int bankBalance)
    {
        Account account = new Account(accountNumber,bankBalance);
        accounts.put(accountNumber,account);
        return account;
    }
    public Card createCard(String cardNumber, int cardPin)
    {
        Card card = new Card(cardNumber,cardPin);
        cards.put(cardNumber,card);

        return card;
    }
    public void linkCardToAccount(Card card, Account account)
    {
        account.getMapCards().put(card.getCardNumber(),card);
        cardAccountMap.put(card,account);
    }

    public boolean authenticate(Card card, int pin)
    {
        if(card.getPinNumber() == pin) return true;
        return  false;
    }
    public int getBalance(Card card)
    {
        Account account = cardAccountMap.get(card);
        return account.getBankBalance();
    }

    public boolean withdrawMoney(Card card, int money)
    {
        Account account = cardAccountMap.get(card);
        return account.removeMoney(money);
    }
    public void depositMoney(Card card, int money)
    {
        Account account = cardAccountMap.get(card);
        account.addMoney(money);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Map<String, Card> getCards() {
        return cards;
    }

    public void setCards(Map<String, Card> cards) {
        this.cards = cards;
    }

    public Map<Card, Account> getCardAccountMap() {
        return cardAccountMap;
    }

    public void setCardAccountMap(Map<Card, Account> cardAccountMap) {
        this.cardAccountMap = cardAccountMap;
    }
}
