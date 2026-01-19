package atm_v2.state;

import atm_v2.AtmMachine;
import atm_v2.entity.Account;
import atm_v2.entity.Card;

public class DepositCashState implements AtmState{
    @Override
    public void insertCard(AtmMachine atmMachine, Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void withdrawCash(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("Deposit cash request by user");
    }

    @Override
    public void depositCash(AtmMachine atmMachine, Card card, int amount) {

        Account account = card.getAccount();
        int original_money = account.getMoney();
        int atm_money = atmMachine.getMoney();
        System.out.println("$ " + amount +" is being added to account");
        account.setMoney(original_money+amount);
        atmMachine.setMoney(atm_money+amount);
        atmMachine.setCurrState(new IdleState());
    }

    @Override
    public void displayBalance(AtmMachine atmMachine, Card card) {
        System.out.println("Deposit cash request by user");
    }

    @Override
    public void maintenanceState(AtmMachine atmMachine) {
        System.out.println("Machine in maintenance state");
    }
}
