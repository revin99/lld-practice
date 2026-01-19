package atm_v2.state;

import atm_v2.AtmMachine;
import atm_v2.entity.Account;
import atm_v2.entity.Card;

import java.util.Scanner;

public class IdleState implements AtmState{

    Scanner sc = new Scanner(System.in);

    private boolean validate(Card card, int enteredPin)
    {
        Account account = card.getAccount(); //get corresponding account associated with card
        String cardNumber = card.getCardNumber(); //get cardNumber of inserted card

        int actualPin = account.getCardPinMapping().get(cardNumber);

        if(actualPin==enteredPin) return true;
        return false;
    }

    @Override
    public void insertCard(AtmMachine atmMachine, Card card) {
        System.out.println("Card is inserted by user");
        System.out.println("Enter PIN of card");
        int enteredPin = sc.nextInt();

        if(validate(card,enteredPin)){

            System.out.println("Correct Pin Entered!");

        }else{
            System.out.println("Wrong pin entered! Re-enter card");
        }

    }

    @Override
    public void withdrawCash(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("Insert card first !!");
    }

    @Override
    public void depositCash(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("Insert card first !!");
    }

    @Override
    public void displayBalance(AtmMachine atmMachine, Card card) {
        System.out.println("Insert card first !!");
    }

    @Override
    public void maintenanceState(AtmMachine atmMachine) {
        System.out.println("Machine is healthy");
    }


}
