package vending_machine.state;

import vending_machine.entities.Money;
import vending_machine.entities.Product;
import vending_machine.entities.VendingMachine;

public class IdleState implements VendingMachineState{
    @Override
    public void selectProduct(VendingMachine vm, Product product) {
//
    }

    @Override
    public void insertMoney(VendingMachine vm, Money money) {
        throw new RuntimeException("Select Product First!");
    }

    @Override
    public void dispenseProduct(VendingMachine vm, Product product) {
        throw new RuntimeException("Select Product First!");
    }

    @Override
    public void returnChange(VendingMachine vm, Money money) {
        throw new RuntimeException("Select Product First!");
    }
}
