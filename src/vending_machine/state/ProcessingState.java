package vending_machine.state;

import vending_machine.entities.Money;
import vending_machine.entities.Product;
import vending_machine.entities.VendingMachine;

public class ProcessingState implements VendingMachineState{
    @Override
    public void selectProduct(VendingMachine vm, Product product) {
        throw new RuntimeException("Product already selected!!");
    }

    @Override
    public void insertMoney(VendingMachine vm, Money money) {

    }

    @Override
    public void dispenseProduct(VendingMachine vm, Product product) {
        //
    }

    @Override
    public void returnChange(VendingMachine vm, Money money) {
       //

    }
}
