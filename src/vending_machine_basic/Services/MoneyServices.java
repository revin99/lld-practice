package vending_machine_basic.Services;

import vending_machine_basic.entities.Denomination;
import vending_machine_basic.entities.Money;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoneyServices {

    private Money money;

    public MoneyServices(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void addMoney(Money newMoney)
    {
        Map<Denomination,Integer> originalMoneyMap = money.getMoneyMap();
        Map<Denomination,Integer> newMoneyMap = newMoney.getMoneyMap();

        for(Map.Entry<Denomination,Integer> entry: newMoneyMap.entrySet())
        {
            originalMoneyMap.put(entry.getKey(),originalMoneyMap.getOrDefault(entry.getKey(),0)+entry.getValue());
        }
        money.setMoneyMap(originalMoneyMap);
    }

    public void removeMoney(Money newMoney)
    {
        Map<Denomination,Integer> originalMoneyMap = money.getMoneyMap();
        Map<Denomination,Integer> newMoneyMap = newMoney.getMoneyMap();
        for(Map.Entry<Denomination,Integer> entry: newMoneyMap.entrySet())
        {
            Denomination denomination = entry.getKey();
            Integer qty = entry.getValue();
            int remaining = originalMoneyMap.get(denomination) - qty;
            originalMoneyMap.put(denomination,remaining);
        }
        money.setMoneyMap(originalMoneyMap);
    }

    public Money convertMoney(int total)
    {
        int fiftys = total/50;
        int leftover = total%50;

        int twentys = total/20;
        leftover = total%20;

        int tens = leftover/10;

        Map<Denomination,Integer> moneyMap = new HashMap<>();
        moneyMap.put(Denomination.FIFTY,fiftys);
        moneyMap.put(Denomination.TWENTY,twentys);
        moneyMap.put(Denomination.TEN,tens);

        Money money1 = new Money(moneyMap);
        return money1;

    }



}
