package vending_machine_v2.state;

import vending_machine_v2.VendingMachine;
import vending_machine_v2.entity.Money;
import vending_machine_v2.enums.Denomination;

import java.util.Map;

public class ProcessRefundState implements VendingMachineState{
    @Override
    public void insertMoney(VendingMachine context, Money money) {
        System.out.println("Processing refund");
    }

    @Override
    public boolean selectProduct(VendingMachine context, int productId, int quantity) {
        System.out.println("Processing refund");
        return true;
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Processing refund");
    }

    @Override
    public void processRefund(VendingMachine context) {

        Money insertedMoney = context.getInsertedMoney();
        Money vmMoney = context.getTotalMoney();

        Map<Denomination,Integer> insertedMoneyMap = insertedMoney.getMoneyMap();
        Map<Denomination,Integer> vmMoneyMap = vmMoney.getMoneyMap();

        for(Map.Entry<Denomination,Integer> entry: insertedMoneyMap.entrySet())
        {
            Denomination deno = entry.getKey();
            int qty = entry.getValue();
            int originalQty = vmMoneyMap.get(deno);
            vmMoneyMap.put(deno,originalQty-qty);
        }
        vmMoney.setMoneyMap(vmMoneyMap);
        context.setTotalMoney(vmMoney);

        context.setInsertedMoney(new Money());
        System.out.println("Refund has been processed");
    }

    @Override
    public void enterMaintenance(VendingMachine context) {
        System.out.println("Processing refund");
    }
}
