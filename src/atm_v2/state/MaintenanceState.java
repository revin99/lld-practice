package atm_v2.state;

import atm_v2.AtmMachine;
import atm_v2.entity.Card;

public class MaintenanceState implements AtmState{
    @Override
    public void insertCard(AtmMachine atmMachine, Card card) {
        System.out.println("In Maintenance state");
    }

    @Override
    public void withdrawCash(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("In Maintenance state");
    }

    @Override
    public void depositCash(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("In Maintenance state");
    }

    @Override
    public void displayBalance(AtmMachine atmMachine, Card card) {
        System.out.println("In Maintenance state");
    }

    @Override
    public void maintenanceState(AtmMachine atmMachine) {
        System.out.println("In Maintenance state");
    }
}
