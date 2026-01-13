package vending_machine_v2.entity;

import vending_machine_v2.enums.Denomination;

import java.util.HashMap;
import java.util.Map;

public class Money {

    private Map<Denomination,Integer> moneyMap;

    public Map<Denomination, Integer> getMoneyMap() {
        return moneyMap;
    }

    public Money(Map<Denomination, Integer> moneyMap) {
        this.moneyMap = moneyMap;
    }

    public Money() {
        System.out.println("Resetting Money");
        this.moneyMap = new HashMap<Denomination,Integer>();
    }

    public void setMoneyMap(Map<Denomination, Integer> moneyMap) {
        this.moneyMap = moneyMap;
    }

    public double getMoney(){
        double value=0;
        for(Map.Entry<Denomination,Integer> entry: moneyMap.entrySet())
        {
            value+=(entry.getKey().getValue()*entry.getValue()); //denomination * quantity of each denomination
        }
        return value;
    }
}
