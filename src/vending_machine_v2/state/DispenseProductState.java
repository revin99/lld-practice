package vending_machine_v2.state;

import vending_machine_v2.VendingMachine;
import vending_machine_v2.entity.Money;

public class DispenseProductState implements VendingMachineState{
    @Override
    public void insertMoney(VendingMachine context, Money money) {
        System.out.println("Dispensing Product");
    }

    @Override
    public boolean selectProduct(VendingMachine context, int productId, int quantity) {
        System.out.println("Dispensing Product");
        return true;
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Product has been dispensed");
        context.setInsertedMoney(new Money());
        context.setCurrentState(new IdleState());
    }

    @Override
    public void processRefund(VendingMachine context) {
        System.out.println("Dispensing Product");
        context.setInsertedMoney(new Money());
    }

    @Override
    public void enterMaintenance(VendingMachine context) {
        System.out.println("Dispensing Product");
    }
}
