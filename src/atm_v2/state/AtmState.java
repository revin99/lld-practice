package atm_v2.state;

import atm_v2.AtmMachine;
import atm_v2.entity.Card;

public interface AtmState {

    public void insertCard(AtmMachine atmMachine, Card card);
    public void withdrawCash(AtmMachine atmMachine, Card card, int amount);
    public void depositCash(AtmMachine atmMachine, Card card, int amount);
    public void displayBalance(AtmMachine atmMachine, Card card);
    public void maintenanceState(AtmMachine atmMachine);


}
