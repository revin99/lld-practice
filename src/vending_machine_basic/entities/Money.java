package vending_machine_basic.entities;

import java.util.Map;

public class Money {

    Map<Denomination,Integer> moneyMap;
    int total;

    public int getTotal() {
        int total =0;
        for(Map.Entry<Denomination,Integer> entry: moneyMap.entrySet())
        {
            Denomination denomination = entry.getKey();
            Integer qty = entry.getValue();
            total+=denomination.getValue()*qty;
        }
        return total;
    }


    public Money(Map<Denomination, Integer> moneyMap) {
        this.moneyMap = moneyMap;
    }

    public Map<Denomination, Integer> getMoneyMap() {
        return moneyMap;
    }

    public void setMoneyMap(Map<Denomination, Integer> moneyMap) {
        this.moneyMap = moneyMap;

        this.total=getTotal();
    }




}
