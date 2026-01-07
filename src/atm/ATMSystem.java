package atm;

import atm.chain.*;
import atm.entities.Bank;
import atm.entities.Card;
import atm.entities.CashDispenser;
import atm.entities.OperationType;
import atm.state.ATMState;
import atm.state.IdleState;

import java.util.concurrent.atomic.AtomicLong;

public class ATMSystem {

    private static ATMSystem INSTANCE;
    private Bank bank;
    private CashDispenser cashDispenser;
    private static final AtomicLong transactionCounter = new AtomicLong(0);
    private ATMState currentState;
    private Card currentCard;

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    private ATMSystem(){
        this.currentState = new IdleState();
        this.bank = new Bank();

        DispenseChain c1 = new NoteDispenser100(10);
        DispenseChain c2 = new NoteDispenser20(20);
        DispenseChain c3 = new NoteDispenser10(30);
        c1.setNextChain(c2);
        c2.setNextChain(c3);

        this.cashDispenser= new CashDispenser(c1);
    }

    public static ATMSystem getInstance(){
        if(INSTANCE==null) INSTANCE = new ATMSystem();
        return INSTANCE;
    }

    public void changeState(ATMState newState){
        this.currentState = newState;
    }
    public void currentCard(Card card){
        this.currentCard = card;
    }

    public void insertCard(String cardNumber) {
        currentState.insertCard(this, cardNumber);
    }

    public void enterPin(int pin) {
        currentState.enterPin(this, pin);
    }

    public void selectOperation(OperationType op, int... args) { currentState.selectOperation(this, op, args); }

    public Card getCard(String cardNumber) {
        return bank.getCards().get(cardNumber);
    }

    public boolean authenticate(int pin) {
        return bank.authenticate(currentCard, pin);
    }

    public void checkBalance() {
        double balance = bank.getBalance(currentCard);
        System.out.printf("Your current account balance is: $%.2f%n", balance);
    }

    public void withdrawCash(int amount) {
        if (!cashDispenser.canDispenseCash(amount)) {
            throw new IllegalStateException("Insufficient cash available in the ATM.");
        }

        bank.withdrawMoney(currentCard, amount);

        try {
            cashDispenser.dispenseCash(amount);
        } catch (Exception e) {
            bank.depositMoney(currentCard, amount); // Deposit back if dispensing fails
        }
    }

    public void depositCash(int amount) {
        bank.depositMoney(currentCard, amount);
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Bank getBankService() {
        return bank;
    }


}
