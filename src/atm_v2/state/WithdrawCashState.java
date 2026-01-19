package atm_v2.state;

import atm_v2.AtmMachine;
import atm_v2.entity.Account;
import atm_v2.entity.Card;

public class WithdrawCashState implements AtmState{
    @Override
    public void insertCard(AtmMachine atmMachine, Card card) {
        System.out.println("Card is already inserted");
    }

    @Override
    public void withdrawCash(AtmMachine atmMachine, Card card, int amount) {

        Account account = card.getAccount();
        int original_money = account.getMoney();
        int atm_money = atmMachine.getMoney();
        if(original_money>=amount && atm_money>=amount){
            System.out.println("$ " + amount +" is being dispensed");
            account.setMoney(original_money-amount);
            atmMachine.setMoney(atm_money-amount);
        }else{
            System.out.println("Bank account does not have enough funds");
        }
        atmMachine.setCurrState(new IdleState());
    }

    @Override
    public void depositCash(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("Request for withdraw cash");
    }

    @Override
    public void displayBalance(AtmMachine atmMachine, Card card) {
        System.out.println("Request for withdraw cash");
    }

    @Override
    public void maintenanceState(AtmMachine atmMachine) {
        System.out.println("Machine is healthy");
    }
}
