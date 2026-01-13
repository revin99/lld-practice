package vending_machine_v2.state;

import vending_machine_v2.VendingMachine;
import vending_machine_v2.entity.Inventory;
import vending_machine_v2.entity.Money;
import vending_machine_v2.entity.Product;

import java.util.Map;

public class HasMoneyState implements VendingMachineState{
    @Override
    public void insertMoney(VendingMachine context, Money money) {
        System.out.println("Money already inserted");
    }

    @Override
    public boolean selectProduct(VendingMachine context, int productId, int quantity) {

        System.out.println("Selecting product!!");
        Money insertedMoney = context.getInsertedMoney();

        Inventory inventory = context.getInventory();

        if(inventory.isProductAvailable(productId)==false) {
            context.setCurrentState(new ProcessRefundState());
             return false;
        }

        Product product = inventory.getProduct(productId);
        double requiredPrice = product.getPrice()*quantity;
        double insertedMoneyValue = insertedMoney.getMoney();

        if(insertedMoneyValue<requiredPrice){
            context.setCurrentState(new ProcessRefundState());
            return false;
        }

        System.out.println("Product selected");

        inventory.removeProduct(productId,quantity);
        context.setInventory(inventory);

        context.setCurrentState(new DispenseProductState());
        return true;
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Select Product first");
    }

    @Override
    public void processRefund(VendingMachine context) {
        System.out.println("Select Product first");
    }

    @Override
    public void enterMaintenance(VendingMachine context) {
        System.out.println("Select Product first");
    }
}
