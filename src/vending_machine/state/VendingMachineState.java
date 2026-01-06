package vending_machine.state;

import vending_machine.entities.Money;
import vending_machine.entities.Product;
import vending_machine.entities.VendingMachine;

public interface VendingMachineState {

    void selectProduct(VendingMachine vm, Product product);
    void insertMoney(VendingMachine vm, Money money);
    void dispenseProduct(VendingMachine vm, Product product);
    void returnChange(VendingMachine vm, Money money);
}
