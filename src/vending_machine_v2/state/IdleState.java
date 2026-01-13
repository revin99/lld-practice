package vending_machine_v2.state;

import vending_machine_v2.VendingMachine;
import vending_machine_v2.entity.Money;
import vending_machine_v2.enums.Denomination;

import java.util.Map;

public class IdleState implements VendingMachineState{
    @Override
    public void insertMoney(VendingMachine context, Money money) {
        System.out.println("Inserting Money");

        Money vmMoney = context.getTotalMoney();
        Map<Denomination,Integer> vmMoneyMap = vmMoney.getMoneyMap();
        for(Map.Entry<Denomination,Integer>entry : money.getMoneyMap().entrySet())
        {
            int qty = vmMoneyMap.get(entry.getKey());
            qty+=entry.getValue();
            vmMoneyMap.put(entry.getKey(),qty);
        }
        vmMoney.setMoneyMap(vmMoneyMap);
        context.setTotalMoney(vmMoney);

        System.out.println("Added money to the Vending Machine");
        context.setCurrentState(new HasMoneyState());
    }

    @Override
    public boolean selectProduct(VendingMachine context, int productId, int quantity) {
        System.out.println("First enter Money !!");
        return  true;
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("First enter Money !!");
    }

    @Override
    public void processRefund(VendingMachine context) {
        System.out.println("First enter Money !!");
    }

    @Override
    public void enterMaintenance(VendingMachine context) {
        System.out.println("First enter Money !!");
    }
}
