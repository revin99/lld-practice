package vending_machine_v2;

import vending_machine_v2.entity.Inventory;
import vending_machine_v2.entity.Money;
import vending_machine_v2.state.IdleState;
import vending_machine_v2.state.VendingMachineState;

public class VendingMachine {

    private static VendingMachine instance;
    private VendingMachineState currentState;
    private Money totalMoney;
    private Money insertedMoney;
    private Inventory inventory;

    private VendingMachine(Inventory inventory, Money totalMoney){
        currentState = new IdleState();
        insertedMoney = new Money();
        this.inventory=inventory;
        this.totalMoney=totalMoney;
    }

    public static VendingMachine getInstance(Inventory inventory,Money totalMoney){
        if(instance==null){
            instance = new VendingMachine(inventory,totalMoney);
        }
        return instance;
    }

    public void insertMoney(Money insertedMoney){
        this.insertedMoney=insertedMoney;
        currentState.insertMoney(this,insertedMoney);
    }

    public boolean selectProduct(int productId, int quantity){
        boolean value = currentState.selectProduct(this,productId,quantity);

        return value;
    }

    public void dispenseProduct(){
        currentState.dispenseProduct(this);
    }

    public void processRefund(){
        currentState.processRefund(this);
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public Money getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Money totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Money getInsertedMoney() {
        return insertedMoney;
    }

    public void setInsertedMoney(Money insertedMoney) {
        this.insertedMoney = insertedMoney;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
