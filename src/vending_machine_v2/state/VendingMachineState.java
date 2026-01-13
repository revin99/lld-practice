package vending_machine_v2.state;


import vending_machine_v2.VendingMachine;
import vending_machine_v2.entity.Money;

public interface VendingMachineState {

    void insertMoney(VendingMachine context, Money money);
    boolean selectProduct(VendingMachine context, int productId, int quantity);
    void dispenseProduct(VendingMachine context);
    void processRefund(VendingMachine context);
    void enterMaintenance(VendingMachine context);
}
