package vending_machine.entities;

import java.util.Map;

public class Money {

    private Map<Denomination,Integer> moneyMap;

    public Money(Map<Denomination, Integer> moneyMap) {
        this.moneyMap = moneyMap;
    }

    public Map<Denomination, Integer> getMoneyMap() {
        return moneyMap;
    }

    public void setMoneyMap(Map<Denomination, Integer> moneyMap) {
        this.moneyMap = moneyMap;
    }

    public int getAmount()
    {
        int amount=0;
        for (Map.Entry<Denomination,Integer> entry: moneyMap.entrySet()) {
            amount = entry.getKey().getValue() * entry.getValue();
        }
        return amount;
    }

    public void deductAmount(Map<Denomination,Integer> deducted){

        for(Map.Entry<Denomination,Integer> entry: deducted.entrySet()) {
            Denomination key = entry.getKey();
            int valueToDeduct = entry.getValue();

            if (moneyMap.containsKey(key)) {
                moneyMap.put(key, moneyMap.get(key) - valueToDeduct);
            }
        }
    }
    public void addAmount(Map<Denomination,Integer> added){

        for(Map.Entry<Denomination,Integer> entry: added.entrySet()) {
            Denomination key = entry.getKey();
            int valueToDeduct = entry.getValue();

            if (moneyMap.containsKey(key)) {
                moneyMap.put(key, moneyMap.get(key) - valueToDeduct);
            }
        }
    }
}
