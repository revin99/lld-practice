package atm_v2.state;

import atm_v2.AtmMachine;
import atm_v2.entity.Account;
import atm_v2.entity.Card;

public class ShowBalanceState implements AtmState{
    @Override
    public void insertCard(AtmMachine atmMachine, Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void withdrawCash(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("System in show balance state");
    }

    @Override
    public void depositCash(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("System in show balance state");
    }

    @Override
    public void displayBalance(AtmMachine atmMachine, Card card) {

        Account account = card.getAccount();
        System.out.println("Balance is " + account.getMoney());
    }

    @Override
    public void maintenanceState(AtmMachine atmMachine) {
        System.out.println("System is healthy");
    }
}
